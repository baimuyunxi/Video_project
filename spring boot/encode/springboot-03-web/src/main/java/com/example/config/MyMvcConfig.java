package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 如果想要diy一些定制化的功能 只要写这个组件 然后将它交给springboot springboot就会帮忙自动装配
// 扩展 springmvc dispatchservlet
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // 视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/yunxi").setViewName("index1");
    }
}
