package com.example.pojo;

import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Controller;

@Controller
//@Api()  // 给实体类添加文档注释
public class User {

    public Integer id;

    public String name;

    public int age;

}
