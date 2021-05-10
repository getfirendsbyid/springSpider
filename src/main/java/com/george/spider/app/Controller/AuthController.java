package com.george.spider.app.Controller;

import com.george.spider.app.Request.Auth.LoginValidator;
import com.george.spider.app.Utils.ImageCode;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController{

    @PostMapping(value = "login")
    public String login(@Validated LoginValidator loginValidator, BindingResult result){
        String code = loginValidator.getCode();
        String username = loginValidator.getUsername();
        String password = loginValidator.getPassword();


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
