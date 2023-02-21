package com.example.controller;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> users = userMapper.queryUserList();
        for (User user : users)
            System.out.println(user);
        return users;
    }

    // 查询用户
    @GetMapping("/selectUserById")
    public User selectUserById(){
        User userById = userMapper.selectUserById(5);
        return userById;
    }

    // 添加用户
    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(2,"沐曦","1123"));
        return "ok";
    }

    // 修改用户
    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(2,"白木","0714"));
        return "ok";
    }

    // 删除用户
    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(2);
        return "ok";
    }
}
