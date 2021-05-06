package com.george.spider.app.Controller;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;

public class BaseController {
    private Integer successCode = 200;
    public String success(String msg , List data){
        HashMap response = new HashMap();
        response.put("code",successCode);
        response.put("msg",msg);
        response.put("data",data);
        JSONObject json = new JSONObject(response);
        return json.toString() ;
    }
    public String error(Integer code, String msg , List data){
        HashMap response = new HashMap();
        response.put("code",code);
        response.put("msg",msg);
        response.put("data",data);
        JSONObject json = new JSONObject(response);
        return json.toString();
    }
}