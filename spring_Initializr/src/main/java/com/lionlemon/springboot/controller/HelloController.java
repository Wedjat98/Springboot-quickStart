package com.lionlemon.springboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hellos")
public class HelloController {

    @GetMapping("here")
    public String sayHi(){
        return "<h1>hello</h1>";
    }
}
