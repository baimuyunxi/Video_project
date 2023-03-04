package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
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
    public Docket docket(Environment environment) {

        // 设置要显示的 swagger 环境
        Profiles profiles = Profiles.of("dev");

        // 通过 environment.acceptsProfiles 判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 配置 api 文档的分组
                .groupName("白木云曦")
                .enable(flag)  // .enable 是否启动swagger
                .select()
                // RequestHandlerSelectors.basePackage 指定扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .build();
    }

    /*   配置多个api分组就配置多个Docket方法
    @Bean
    public Docket docket1(Environment environment) {

        // 设置要显示的 swagger 环境
        Profiles profiles = Profiles.of("dev");

        // 通过 environment.acceptsProfiles 判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 配置 api 文档的分组
                .groupName("A")
                .enable(flag)  // .enable 是否启动swagger
                .select()
                // RequestHandlerSelectors.basePackage 指定扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .build();
    }
    @Bean
    public Docket docket2(Environment environment) {

        // 设置要显示的 swagger 环境
        Profiles profiles = Profiles.of("dev");

        // 通过 environment.acceptsProfiles 判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 配置 api 文档的分组
                .groupName("B")
                .enable(flag)  // .enable 是否启动swagger
                .select()
                // RequestHandlerSelectors.basePackage 指定扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .build();
    }
    @Bean
    public Docket docket3(Environment environment) {

        // 设置要显示的 swagger 环境
        Profiles profiles = Profiles.of("dev");

        // 通过 environment.acceptsProfiles 判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 配置 api 文档的分组
                .groupName("C")
                .enable(flag)  // .enable 是否启动swagger
                .select()
                // RequestHandlerSelectors.basePackage 指定扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .build();
    }
     */
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
