package com.george.spider.app.Task.Ji;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.concurrent.Future;

import com.alibaba.fastjson.JSON;
import com.george.spider.app.ServiceImpl.AnimeServiceImpl;
import com.george.spider.app.Utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;


@Component
public class AnimeTask {

    @Autowired
    private AnimeServiceImpl animeService;

    @Async
    public Future<String> task1(Integer page)  {
        System.out.println("thread:"+Thread.currentThread().getName());
        String url ="http://api.jijiweb.cn/v1/anime/anime_list.php";
        Map<String, Object> object = new HashMap<>();
        object.put("year","全部年份");
        object.put("where","全部地区");
        object.put("tag","全部标签");
        object.put("page_long","100");
        object.put("page_num",page);
        String html = null;
        try {
            html = HttpClientUtils.httpPostRequest(url,object);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<HashMap> response = JSON.parseArray(JSON.parseObject(html).getString("list"), HashMap.class);

        Collection savaData = new ArrayList();
        for (Integer i =0;i<response.size(); i++){
            com.george.spider.app.Entity.Anime animeEntity = new com.george.spider.app.Entity.Anime();
            LocalDateTime localDateTime = LocalDateTime.ofEpochSecond( Integer.parseInt(response.get(i).get("time").toString()), 0, ZoneOffset.ofHours(8));
            animeEntity.setAnime(response.get(i).get("name").toString());
            animeEntity.setCover(response.get(i).get("cover").toString());
            animeEntity.setCratedat(LocalDateTime.now());
            animeEntity.setUpdatedat(LocalDateTime.now());
            animeEntity.setPlaytime(localDateTime);
            savaData.add(animeEntity);
        }
        System.out.println(savaData);
        boolean b = animeService.saveBatch(savaData);
        return null;
    }






}