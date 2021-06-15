package com.lionlemon.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller+@ResponseBody
@RequestMapping("hello")
public class HelloController {
    //hello/boot
    @GetMapping("boot")
    public String SayHi(){
        return "<h1>hello spring boot~~~~</h1>";
    }
}
