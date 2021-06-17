package com.lionlemon.springdatademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBC_controller {


    final
    JdbcTemplate jdbcTemplate;
    @GetMapping("/students")
    public List<Map<String,Object>> mapList(){
        String sql="select * from stu";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        return result;
    }

    @GetMapping("/addUser")
    public String adduser(){
        String sql = "insert into db1.stu(id,name,age,score,birth) values (2,'小仙猪',10,98.9,'1920-1-1')";
        int isOK = jdbcTemplate.update(sql);
        return "success!!"+isOK;
    }


    public JDBC_controller(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
