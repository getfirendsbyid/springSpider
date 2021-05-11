package com.george.spider.app.Controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.george.spider.app.Entity.Users;
import com.george.spider.app.Logic.AuthLogic;
import com.george.spider.app.Mapper.UsersMapper;
import com.george.spider.app.Request.Auth.LoginValidator;
//import com.george.spider.app.Utils.ImageCode;
import com.george.spider.app.Request.Auth.RegisterValidator;
import com.george.spider.app.Response.Response;
import com.george.spider.app.Utils.JWTTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
@ControllerAdvice
@RequestMapping("/auth")
public class AuthController extends BaseController{

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private AuthLogic authLogic;

    @Autowired
    private UsersMapper usersMapper;

    @PostMapping("login")
    public Response<Object> login(@Validated LoginValidator loginValidator, BindingResult result) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String code = loginValidator.getCode();
        String token = loginValidator.getToken();
        String username = loginValidator.getUsername();
        String password = loginValidator.getPassword();
        //验证验证码是否正确
        boolean hasTrue = authLogic.checkCaptcha(code,token);
        if (!hasTrue){
            return Response.error( "验证码不正确");
        }
        //验证账号密码
        QueryWrapper<Users> userNameWrapper = new QueryWrapper<>();
        userNameWrapper.eq("username", username);
        Users users = usersMapper.selectOne(userNameWrapper);
        if (users==null){
            return Response.error("用户名不存在");
        }
        boolean checkPassword = authLogic.passwordValidator(password, users.getPassword());
        if (!checkPassword){
            return Response.error("用户名或密码不正确");
        }
        //jwt 生成token
        String JWTToken = JWTTokenUtils.createToken(username);
        System.out.println(JWTToken);
        return Response.success("请求成功");
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
    public Object register(@Validated RegisterValidator registerValidator, BindingResult result) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String code = registerValidator.getVerifyCode();
        String token = registerValidator.getCToken();
        String username = registerValidator.getUsername();
        String password = registerValidator.getPassword();
        String email = registerValidator.getPassword();
        String rePassword = registerValidator.getRePassword();
        if (!rePassword.equals(password)){
            return Response.error("两次密码不一致");
        }
        //校验验证码是否正确
        boolean checkCaptcha = authLogic.checkCaptcha(code,token);
        if (!checkCaptcha){
            return Response.error( "验证码不正确");
        }
        //验证账号是否已经被使用
        QueryWrapper registQuseryWrapper = new QueryWrapper();
        registQuseryWrapper.eq("username",username);
        Users usersData = usersMapper.selectOne(registQuseryWrapper);
        if (usersData!=null){
            return Response.error("该账号已注册");
        }

        //密码加密
        String encodePassword = authLogic.passwordEncode(password);
        //添加用户
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(encodePassword);
        users.setEmail(email);
        int insertUser = usersMapper.insert(users);
        if (insertUser>0){
           return Response.success("注册成功");
        }
        return Response.error("注册失败,请联系管理员");
    }
}
