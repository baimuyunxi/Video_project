package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@Configuration
@EnableSwagger2
//@EnableWebMvc
public class SwaggerConfig {

    // 作者信息
    public static final Contact DEFAULT_CONTACT = new Contact("云曦", "", "baimuyunxi@outlook.com");
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    public ApiInfo apiInfo() {
        return new ApiInfo(
                "Api BaiMuYunXi",
                "Api Documentation",
                "1.0",
                "urn:tos",
                 DEFAULT_CONTACT,
                "Apache 2.0",
                "http" + "://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
