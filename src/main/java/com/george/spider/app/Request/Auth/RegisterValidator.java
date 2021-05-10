package com.george.spider.app.Request.Auth;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class RegisterValidator implements Serializable {

    @NotBlank(message = "用户名不能为空" )
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    @NotBlank(message = "重复密码不能为空")
    private String rePassword;

    @NotBlank(message = "cToken不能为空")
    private String cToken;

    @NotBlank(message = "验证码不能为空")
    private String verifyCode;

}
