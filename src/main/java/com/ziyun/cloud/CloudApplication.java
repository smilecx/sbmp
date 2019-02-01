package com.ziyun.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = {"com.ziyun.cloud.config","com.ziyun.cloud.module.*.controller","com.ziyun.cloud.module.*.service"})
@MapperScan(basePackages = {"com.ziyun.cloud.module.*.mapper"})
@EnableWebMvc
@SpringBootApplication
public class CloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudApplication.class, args);
    }

}