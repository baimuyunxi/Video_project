package com.example.hellospring.controller;

import org.springframework.web.bind.annotation.*;

//	@Controller 的衍生注解  @Controller处理 Http 请求
@RestController
//路由请求 可以设置各种操作方法
@RequestMapping("/hello")
public class HelloController {

    //GET 方法的路由
    @GetMapping("/hello")
    //返回 json 格式
    @ResponseBody
    public String toString() {
        return "Hello! Spring Boot!";
    }
}
