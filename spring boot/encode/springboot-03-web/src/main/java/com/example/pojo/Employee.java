package com.example.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//员工表
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender; //0:女，1：男

    private Department department;
    private Date birth;

    public Employee(Department department) {
        //默认的创建日期
        this.birth = new Date();
    }
}
