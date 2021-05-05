package com.george.spider.app.Thread.Mili;

import com.george.spider.app.Utils.HttpClientUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Anime implements Runnable{
    @Override
    public void run() {
        String url ="https://www.uviewui.com/components/swiper.html";
        String html = HttpClientUtils.httpGetRequest(url);
        Document document = Jsoup.parse(html);
        Element title = document.getElementsByTag("title").first();

    }
}

