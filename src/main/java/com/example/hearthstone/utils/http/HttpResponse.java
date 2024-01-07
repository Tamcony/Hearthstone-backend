package com.example.hearthstone.utils.http;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class HttpResponse implements Serializable {
    private Integer code;
    private String message;
    private Object data;
    public void error(){
        this.code = ResultCode.ERROR;
        this.message = "服务器错误";
        this.data = null;
    }

    public void success(Object data){
        this.code = ResultCode.SUCCESS;
        this.message = "";
        this.data = data;
    }
}
