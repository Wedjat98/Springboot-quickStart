package com.lionlemon.pojo;

public class ArgumentsInvalidResponseBean {

    private String argumentName;
    private String exceptionMsg;

    public ArgumentsInvalidResponseBean() {
    }

    public ArgumentsInvalidResponseBean(String argumentName, String exceptionMsg) {
        this.argumentName = argumentName;
        this.exceptionMsg = exceptionMsg;
    }

    public String getArgumentName() {
        return argumentName;
    }
    public void setArgumentName(String argumentName) {
        this.argumentName = argumentName;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }
    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
