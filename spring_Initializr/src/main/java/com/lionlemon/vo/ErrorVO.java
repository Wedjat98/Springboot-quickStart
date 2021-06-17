package com.lionlemon.vo;

import java.util.Date;
import java.util.Map;

public class ErrorVO {
    private Date timestamp;
    private Map<String, String[]> params;
    private String desc;

    public ErrorVO(Date timestamp, Map<String, String[]> params, String desc) {
        this.timestamp = timestamp;
        this.params = params;
        this.desc = desc;
    }


}
