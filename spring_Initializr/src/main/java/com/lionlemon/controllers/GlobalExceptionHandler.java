package com.lionlemon.controllers;

import com.lionlemon.pojo.ArgumentsInvalidResponseBean;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    public List<ArgumentsInvalidResponseBean> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
        System.out.println("===================methodArgumentNotValidExceptionHandler Occur============");

        List<ArgumentsInvalidResponseBean> argumentsInvalidResponseBeanList = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()){
            ArgumentsInvalidResponseBean bean = new ArgumentsInvalidResponseBean();
            bean.setArgumentName(error.getField());
            bean.setExceptionMsg(error.getDefaultMessage());

            argumentsInvalidResponseBeanList.add(bean);
        }
        return argumentsInvalidResponseBeanList;
    }
}
