package com.george.spider.app.Controller;

import com.george.spider.app.Utils.HttpAsynClientUtils;
import com.george.spider.app.Utils.HttpClientUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/index")
    public String sayHello() throws IOException, InterruptedException {
        String url ="https://www.uviewui.com/components/swiper.html";
        String[] strs = new String[100];
        for (int i = 0; i < 100; i++) {
            strs[i] = url;
        }
        String  a = HttpAsynClientUtils.httpGetRequest(strs);
        System.out.println(a);
//        Document document = Jsoup.parse(html);
//        Element title = document.getElementsByTag("title").first();
        return "任务投递结束";
    }
}