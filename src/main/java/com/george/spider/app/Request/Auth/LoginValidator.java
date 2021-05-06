package com.george.spider.app.Request.Auth;

import javax.validation.constraints.NotBlank;
import java.security.acl.Group;

public class LoginValidator {

        @NotBlank(message = "用户名不能为空" )
        private String username;

        @NotBlank(message = "密码不能为空")
        private String password;

        @NotBlank(message = "验证码不能为空")
        private String code;

}
