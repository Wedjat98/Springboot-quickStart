package com.lionlemon.exception;
import java.util.logging.Level;
public enum ExceptionType {
    /**
     * 自定义异常
     */
    REDIS_EXCEPTION(1),
    MYSQL_EXCEPTION(2),
    ILLEGAL_PARAM(3);

    final int code;
    final Level level;

    ExceptionType(int code){
        this.code=code;
        this.level=Level.WARNING;
    }

    ExceptionType(int code,Level level){
        this.code=code;
        this.level=level;
    }

    public int getCode(){
        return code;
    }

}
