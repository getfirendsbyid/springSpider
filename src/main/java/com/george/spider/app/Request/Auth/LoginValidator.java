package com.george.spider.app.Request.Auth;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.security.acl.Group;

@Data
public class LoginValidator implements Serializable {

        @NotBlank(message = "用户名不能为空" )
        private String username;

        @NotBlank(message = "密码不能为空")
        private String password;

        @NotBlank(message = "cToken不能为空")
        private String token;

        @NotBlank(message = "验证码不能为空")
        private String code;

}
