package com.george.spider.app.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class AuthLogic {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    /**
     * 验证验证码是否正确
     * @param code
     * @param token
     * @return
     */
    public boolean checkCaptcha(String code, String token){
        String trueCode = (String) redisTemplate.opsForValue().get("captchaToken:" + token);
        if (trueCode==null){
            return false;
        }
        if (trueCode.equals(code)){
           return true;
        }
        return false;
    }

    public String passwordEncode(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        return base64en.encode(md5.digest(password.getBytes("utf-8")));
    }

    public boolean passwordValidator(String password, String encodePassword) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if(passwordEncode(password).equals(encodePassword)){
            return true;
        }else{
            return false;
        }
    }
}
