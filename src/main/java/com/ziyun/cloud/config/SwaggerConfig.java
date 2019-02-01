package com.ziyun.cloud.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:chenxiaoyi
 * @Date:2019/1/31 19:50
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Autowired
    private StandardEnvironment standardEnvironment;


    @Bean
    public Docket createRestApi(){
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder appPar = new ParameterBuilder();
        appPar.name("appytpe").description("app类型").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(appPar.build());
        appPar.name("userid").description("用户id").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(appPar.build());

        String application = standardEnvironment.getProperty("spring.application.name");
        String applicationName = StringUtils.substringBefore(application, "-");
        String basePackage = StringUtils.EMPTY;
        switch (applicationName){
            case "api":
                basePackage = "com.ziyun.cloud.model";
                break;
            default:
                basePackage = "com.ziyun";
                break;
        }

        return new Docket(DocumentationType.SWAGGER_2).select().apis(basePackage(basePackage))
                .paths(PathSelectors.any()).build().globalOperationParameters(pars).apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        String application = standardEnvironment.getProperty("spring.application.name");
        return new ApiInfoBuilder().title(application + " Api文档,").version("1.0")
                .description(
                        "apptype--Type[String]      客户端(ios,Android);</br>" + "userid---Type[String]		用户ID;</br>")
                .build();
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(",")) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }
}
