package com.george.spider.app.Response;

import com.george.spider.app.Enum.ResponseCodeEnum;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@Builder
public class Response<T>  {

    private int code;
    private String msg;
    private T data;

    private Response(int code){
        this.code = code;
    }

    private Response(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private Response(int code,T data){
        this.code = code;
        this.data = data;
    }


    private Response(int code,String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response() {

    }


    public static <T> Response<T> success(T data){
        Response<T> response = new Response<T>();
        response.setCode(ResponseCodeEnum.SUCCESS.getCode());
        response.setData(data);
        return response;
    }

    public static <T> Response<T> success(String msg, T data){
        Response<T> response = new Response<T>();
        response.setCode(ResponseCodeEnum.SUCCESS.getCode());
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> error(String msg){
        Response<T> response = new Response<T>();
        response.setCode(ResponseCodeEnum.ERROR.getCode());
        response.setMsg(msg);
        return response;
    }

    public static <T> Response<T> error(int code, String msg){
        Response<T> response = new Response<T>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

}