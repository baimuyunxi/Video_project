package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Slf4j  //  log 打印注释
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("进行静态资源映射......");
        registry.addResourceHandler("/static/backend/**").addResourceLocations("classpath:/static/backend/");
        registry.addResourceHandler("/static/front/**").addResourceLocations("classpath:/static/front/");
    }
}
