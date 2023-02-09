package com.example.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//标注这个类是springboot的应用：启动类下所有的资源导入
@SpringBootApplication
public class HellospringApplication {

    public static void main(String[] args) {
        //将springboot应用启动
        SpringApplication.run(HellospringApplication.class, args);
    }

}
