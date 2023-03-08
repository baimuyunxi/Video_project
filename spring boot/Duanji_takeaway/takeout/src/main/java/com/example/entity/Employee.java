package com.example.entity;

import lombok.Data;

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

    private String idName;

    private String status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long creatUser;

    private Long updateUser;

}
