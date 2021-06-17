package com.lionlemon.thymeleafdemo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","你好，这里是testController");
        return "test";
    }
}
