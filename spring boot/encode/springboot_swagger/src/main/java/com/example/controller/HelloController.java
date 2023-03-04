package com.example.controller;

import com.example.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello! swagger!";
    }

    // 只要我们接口返回值中存在实体类 就会被扫描到swagger中
    @PostMapping(value = "/user")
    public User user() {
        return new User();
    }

    @ApiOperation("hello控制类")
    @GetMapping(value = "/hello1")
    public String hello2(@ApiParam("名字") String name) {
        return "hello" + name;
    }

    @ApiOperation("Post测试类")
    @PostMapping(value = "/postt")
    public User postt(@ApiParam("名字") User user) {
        return user;
    }

}
