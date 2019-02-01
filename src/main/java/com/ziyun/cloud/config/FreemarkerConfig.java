package com.ziyun.cloud.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;

/**
 * @Author:chenxiaoyi
 * @Date:2019/2/1 13:56
 */
@Configuration
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FreemarkerConfig {
    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;


    // @Value("${webctx}")
    // TODO oss or local
    private String webctx = "../../static";

    // Spring 初始化的时候加载配置
    @PostConstruct
    public void setConfigure() throws Exception {

        // 加载html的资源路径
        configuration.setSharedVariable("webctx", webctx);

//        freeMarkerConfigurer.getConfiguration().setTagSyntax(0);
    }

}
