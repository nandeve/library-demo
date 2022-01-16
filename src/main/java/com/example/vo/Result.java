package com.example.vo;

import lombok.Data;

//view object 视图对象
@Data
public class Result {
    //请求结果标志
    private Boolean flag;
    //请求结果描述
    private String msg;
    //请求的对象
    private Object data;

    public Result(){}

    public Result(Boolean flag) {
        this.flag = flag;
    }

    public Result(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public Result(String msg) {
        this.flag = false;
        this.msg = msg;
    }
}
