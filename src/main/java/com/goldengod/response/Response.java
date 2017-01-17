package com.goldengod.response;


/**
 * Created by wushuai3 on 2017/1/11.
 */
public abstract class Response extends JsonObject{

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private int code;
    private String msg;
}
