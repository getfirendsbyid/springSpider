package com.george.spider.app.Controller;


import com.google.code.kaptcha.Producer;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CaptchaController
 * @Author: geore
 * @Description: 验证码生成控制器
 */

@RestController
@RequestMapping("/captcha")
public class CaptchaController  extends BaseController{

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private Producer producer;

    private final Integer expireTime = 60 * 5; //5分钟验证码缓存
    @GetMapping("")
    public String captcha() throws IOException
    {
        HashMap<String, Object> map = new HashMap<>();
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        ByteArrayOutputStream outputStream = null;
        BufferedImage image = producer.createImage(text);
        outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        //
        BASE64Encoder encoder = new BASE64Encoder();
        String imageStr=encoder.encode(outputStream.toByteArray());
        map.put("img",imageStr);
        //生成验证码对应的token  以token为key  验证码为value存在redis中
        String codeToken= RandomStringUtils.randomAlphanumeric(32);
        redisTemplate.opsForValue().set("captchaToken."+codeToken, text, expireTime, TimeUnit.MINUTES);
        map.put("cToken", codeToken);
        System.out.println(map);
        return  success("请求成功",map);
    }


}