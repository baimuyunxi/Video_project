package com.example.entity;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

/*
*   员工实体类
*/
@Data
public class Employee {

    private Long id;

    private String name;

    private String username;

    private String password;

    private String phone;

    private String sex;

    private String idNumber;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long createUser;

    private Long updateUser;

}
