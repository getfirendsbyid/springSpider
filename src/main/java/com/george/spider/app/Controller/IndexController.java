package com.george.spider.app.Controller;

import com.george.spider.app.Utils.HttpClientUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/index")
    public String sayHello() {
        String url ="http://www.baidu.com";
        String res = HttpClientUtils.httpGetRequest(url);

        return res;
    }
}