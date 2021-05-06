package com.george.spider.app.Controller;

import com.george.spider.app.Request.Auth.LoginValidator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController{

    @RequestMapping(value = "login" ,method = RequestMethod.POST)
    public String login(@Validated LoginValidator loginValidator, BindingResult result){
        List<FieldError> fieldErrors = result.getFieldErrors();
        if(!fieldErrors.isEmpty()){
            return fieldErrors.get(0).getDefaultMessage();
        }
        return "OK";

    }

    @RequestMapping("register")
    public void register(){

    }
}
