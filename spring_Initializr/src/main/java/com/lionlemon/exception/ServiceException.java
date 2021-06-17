package com.lionlemon.exception;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceException extends Exception{
    protected String msg;
    protected ExceptionType exceptionType;
}
