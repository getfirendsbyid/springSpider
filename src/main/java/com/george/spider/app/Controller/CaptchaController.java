package com.george.spider.app.Controller;


import com.google.code.kaptcha.Producer;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName: CaptchaController
 * @Author: geore
 * @Description: 验证码生成控制器
 */

@RestController
@RequestMapping("/captcha")
public class CaptchaController extends BaseController {

    @Autowired
    private Producer producer;

    @GetMapping("/captchaJpg")
    public void captcha(HttpServletResponse response)throws IOException
    {
        //生成文字验证码
        String code = producer.createText();
        // 获取图片验证码
        BufferedImage image = producer.createImage(code);
        // 直接在浏览器页面进行显示
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }


}