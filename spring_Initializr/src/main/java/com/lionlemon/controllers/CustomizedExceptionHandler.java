package com.lionlemon.controllers;

import com.lionlemon.exception.ExceptionType;
import com.lionlemon.exception.ServiceException;
import com.lionlemon.vo.ErrorVO;
import com.lionlemon.common.CommonJsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;

@RestController
@ControllerAdvice
@Slf4j
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<CommonJsonResponse> globalExceptionHandler(ServiceException ex, WebRequest request){
        ErrorVO errorDetails = new ErrorVO(new Date(), request.getParameterMap(),
                request.getDescription(false));
        ExceptionType exType = ex.getExceptionType();
        if(exType==ExceptionType.REDIS_EXCEPTION||exType==ExceptionType.MYSQL_EXCEPTION){
            // 500 服务器内部错误
            CommonJsonResponse<ErrorVO> response = new CommonJsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    exType.getCode(), ex.getMsg());
            response.setData(errorDetails);
            return new ResponseEntity<CommonJsonResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else if(exType==ExceptionType.ILLEGAL_PARAM){
            // 400 客户端参数错误
            CommonJsonResponse<ErrorVO> response = new CommonJsonResponse<>(HttpStatus.BAD_REQUEST.value(),
                    exType.getCode(), ex.getMsg());
            response.setData(errorDetails);
            return new ResponseEntity<CommonJsonResponse>(response, HttpStatus.BAD_REQUEST);
        }else {
            // catch as 200
            CommonJsonResponse<ErrorVO> response = new CommonJsonResponse<>(HttpStatus.OK.value(),
                    exType.getCode(), ex.getMsg());
            response.setData(errorDetails);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult exceptions = ex.getBindingResult();

        String message = "参数异常";

        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                FieldError fieldError = (FieldError) errors.get(0);
                message = fieldError.getDefaultMessage();
            }
        }
        ErrorVO errorDetails = new ErrorVO(new Date(), request.getParameterMap(),
                request.getDescription(false));
        CommonJsonResponse<ErrorVO> response = new CommonJsonResponse<>(HttpStatus.BAD_REQUEST.value(),
                ExceptionType.ILLEGAL_PARAM.getCode(), message);
        response.setData(errorDetails);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}