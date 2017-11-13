package com.javazhan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by yando on 2017/11/10.
 */

@Configuration //必须存在
@EnableSwagger2 //必须存在
public class Swagger2 {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("HTTP对外开放接口")
                .version("1.0.0")
                .termsOfServiceUrl("http://blog.csdn.net/wenteryan")
                .license("Spring Boot 入门+实战（提供源码哟）")
                .licenseUrl("http://blog.csdn.net/column/details/15021.html")
                .build();
    }
}
