package com.lionlemon.springbootmybatisdemo.controller;

import com.lionlemon.springbootmybatisdemo.mapper.UserMapper;
import com.lionlemon.springbootmybatisdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UseController {
    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @GetMapping("/queryUser")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user:userList) {
            System.out.println(user);
        }
    return userList;
    }



}
