package com.zjgsu.entity;

public class Result<T> {
    private Integer code;
    private String msg;
    private T data;


    public Result(T data) {
        this.code = 1;
        this.msg = "success";
        this.data = data;
    }
    public Result(String msg, Integer code)
    {
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }


    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}
