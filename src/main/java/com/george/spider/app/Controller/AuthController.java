package com.george.spider.app.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.george.spider.app.Entity.Users;
import com.george.spider.app.Logic.AuthLogic;
import com.george.spider.app.Mapper.UsersMapper;
import com.george.spider.app.Request.Auth.LoginValidator;
//import com.george.spider.app.Utils.ImageCode;
import com.george.spider.app.Request.Auth.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController{

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private AuthLogic authLogic;

    @Autowired
    private UsersMapper usersMapper;

    @PostMapping(value = "login")
    public String login(@Validated LoginValidator loginValidator, BindingResult result){
        String code = loginValidator.getVerifyCode();
        String token = loginValidator.getCToken();
        String username = loginValidator.getUsername();
        String password = loginValidator.getPassword();
        //验证验证码是否正确
        boolean hasTrue = authLogic.checkCaptcha(code,token);
        if (!hasTrue){
            return error(1,"验证码不正确",null);
        }
        //验证账号密码
        QueryWrapper<Users> userNameWrapper = new QueryWrapper<>();
        userNameWrapper.eq("username", username);
        Users users = usersMapper.selectOne(userNameWrapper);
        if (users.getPassword().equals()){

        }

//        String verificationCodeIn = (String) httpServletRequest.getSession().getAttribute("verificationCode");
//        httpServletRequest.getSession().removeAttribute("verificationCode");
//        if (StringUtils.isEmpty(verificationCodeIn) || !verificationCodeIn.equals(verificationCode)) {
//            return error(500,"验证码错误，或已失效",null);
//        }


//        List<FieldError> fieldErrors = result.getFieldErrors();
//        if(!fieldErrors.isEmpty()){
//            return fieldErrors.get(0).getDefaultMessage();
//        }
//        return "OK";

    }

    @RequestMapping("register")
    public String register(@Validated RegisterValidator registerValidator, BindingResult result) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String code = registerValidator.getVerifyCode();
        String token = registerValidator.getCToken();
        String username = registerValidator.getUsername();
        String password = registerValidator.getPassword();
        String email = registerValidator.getPassword();
        String rePassword = registerValidator.getRePassword();
        if (!rePassword.equals(password)){
            return error(1,"两次密码不一致",null);
        }
        //验证账号是否已经被使用
        QueryWrapper registQuseryWrapper = new QueryWrapper();
        registQuseryWrapper.eq("username",username);
        Users usersData = usersMapper.selectOne(registQuseryWrapper);
        if (usersData!=null){
            return error(1,"该账号已注册",null);
        }
        //验证验证码
        boolean checkCaptcha = authLogic.checkCaptcha(code, token);
        if (!checkCaptcha){
            return error(1,"验证码错误",null);
        }
        //密码加密
        String encodePassword = authLogic.passwordEncode(password);
        //添加用户
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(encodePassword);
        users.setEmail(email);
        usersMapper.insert(users);

        return code;
    }
}
