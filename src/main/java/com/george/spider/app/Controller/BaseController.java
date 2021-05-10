package com.george.spider.app.Controller;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController<T> {
    private Integer successCode = 200;

    public String success(T msg , T data){
        HashMap<String,T> response = new HashMap<String,T>();
        response.put("code", (T) successCode);
        response.put("msg",msg);
        response.put("data",data);
        JSONObject json = new JSONObject((Map<String, Object>) response);
        return json.toString();
    }

    public String error(T code, T msg , T data){
        HashMap<String,T> response = new HashMap<String,T>();
        response.put("code",code);
        response.put("msg",msg);
        response.put("data",data);
        JSONObject json = new JSONObject((Map<String, Object>) response);
        return json.toString();
    }
}