package com.george.spider.app.Thread;


import com.george.spider.app.Utils.HttpClientUtils;

public class Mi implements Runnable{

    @Override
    public void run() {
        String url  = "http://www.baidu.com";
        String a = HttpClientUtils.httpGetRequest(url);
        try {
            Thread.sleep(1000);    //延时2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
        System.out.println("线程："+Thread.currentThread().getName());
    }
}
