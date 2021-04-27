package com.george.spider.app.Task.milimili;

import com.george.spider.app.Task.AsyncService;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.server.Http2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.nio.charset.StandardCharsets;


@Service
class getAcg implements AsyncService {
    private static Logger logger = LogManager.getLogger(getAcg.class.getName());

    @Async("asyncServiceExecutor")
    @Override
    public void writeTxt(){
        logger.info("线程-" + Thread.currentThread().getId() + "在执行写入");
        try {
            String url = "http://www.milimili.com";
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            CloseableHttpResponse response;
            response = closeableHttpClient.execute(httpget);
            //获取响应结果
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            System.out.println(s);
            //确保流关闭
            EntityUtils.consume(entity);
        }catch (Exception e) {
            logger.info(e.getMessage());
        }finally {

        }
    }


}