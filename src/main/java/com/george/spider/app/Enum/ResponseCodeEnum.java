package com.george.spider.app.Enum;

import lombok.Data;

public enum ResponseCodeEnum {

    SUCCESS(0,"请求成功"),
    ERROR(1,"失败");

    private final int code;
    private final String name;

    ResponseCodeEnum(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode(){
        return code;
    }

    public String getName(){
        return name;
    }
}
