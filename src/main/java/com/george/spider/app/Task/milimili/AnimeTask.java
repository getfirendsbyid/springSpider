package com.george.spider.app.Task.milimili;

import com.george.spider.app.Utils.HttpClientUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class AnimeTask implements Runnable{
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        String url ="https://www.uviewui.com/components/swiper.html";
        String html = HttpClientUtils.httpGetRequest(url);

        Document document = Jsoup.parse(html);
        Element title = document.getElementsByTag("title").first();

    }


}
