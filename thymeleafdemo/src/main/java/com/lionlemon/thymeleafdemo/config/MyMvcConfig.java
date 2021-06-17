package com.lionlemon.thymeleafdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;
//扩展SpringMVC 官方建议@con
@Configuration
public class MyMvcConfig implements WebMvcConfigurer { //扩展mvc
    public static class MyViewResolver implements ViewResolver {

        //视图解析器
        @Bean
        public ViewResolver myViewResolver(){
            return new MyViewResolver();
        }
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/registry").setViewName("test");

    }
}
