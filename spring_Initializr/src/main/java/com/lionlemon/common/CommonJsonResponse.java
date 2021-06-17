package com.lionlemon.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Setter
@Getter
public class CommonJsonResponse<T> {
    public static final String MSG_SUCCESS = "SUCCESS";
    public static final String MSG_NOT_FOUND = "NOT FOUND";
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CODE_NO_SUCH_OBJECT = 404;
    /**
     * 200 OK, 500 internal error, mapping of response code
     */
    private int status;
    /**
     * 0 means success
     */
    private int errorCode;

    /**
     * SUCCESS or others
     */
    private String msg;

    /**
     * the result data, may user info or others
     */
    private T data;

    public CommonJsonResponse() {
    }

    public CommonJsonResponse(int status, int errorCode) {
        this.status = status;
        this.errorCode = errorCode;
    }

    public CommonJsonResponse(int status, int errorCode, String msg) {
        this.status = status;
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public static CommonJsonResponse ok() {
        CommonJsonResponse res = new CommonJsonResponse(HttpStatus.OK.value(), CommonJsonResponse.ERROR_CODE_SUCCESS);
        res.setMsg(CommonJsonResponse.MSG_SUCCESS);
        return res;
    }

    public static<T> CommonJsonResponse ok(T t) {
        CommonJsonResponse res = new CommonJsonResponse(HttpStatus.OK.value(), CommonJsonResponse.ERROR_CODE_SUCCESS);
        res.setMsg(CommonJsonResponse.MSG_SUCCESS);
        res.setData(t);
        return res;
    }
}