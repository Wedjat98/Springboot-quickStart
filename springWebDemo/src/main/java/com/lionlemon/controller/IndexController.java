package com.lionlemon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//templates目录下的所有文件只能通过controller来访问
//需要模板引擎
@RestController
public class IndexController {
    @GetMapping("index")
    public String index(){
        return "index";
    }
}
