package com.george.spider.app.Task.ageFans;

import com.alibaba.fastjson.JSON;
import com.george.spider.app.ServiceImpl.AnimeServiceImpl;
import com.george.spider.app.ServiceImpl.TagServiceImpl;
import com.george.spider.app.Utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;


@Component
public class Anime {

    @Autowired
    private AnimeServiceImpl animeService;
    @Autowired
    private TagServiceImpl tagService;

    @Async
    public Future<String> getAnime(Integer page)  {
        System.out.println("thread:"+Thread.currentThread().getName());
        String url ="https://api.agefans.app/v2/catalog?genre=all&label=all&letter=all&order=更新时间&region=all&resource=all&season=all&status=all&year=all&page="+page+"&size=10";
        String html = null;
        html = HttpClientUtils.httpGetRequest(url);
        System.out.println("第"+page+"页");
        System.out.println(html);

        List<HashMap> response = JSON.parseArray(JSON.parseObject(html).getString("list"), HashMap.class);
        Collection savaData = new ArrayList();

        for (Integer i =0;i<response.size(); i++){
            com.george.spider.app.Entity.Anime animeEntity = new com.george.spider.app.Entity.Anime();
            LocalDateTime localDateTime = LocalDateTime.ofEpochSecond( Integer.parseInt(response.get(i).get("time").toString()), 0, ZoneOffset.ofHours(8));
            animeEntity.setUpdatedat(LocalDateTime.now());
            animeEntity.setPlaytime(localDateTime);
            savaData.add(animeEntity);//存储数据
        }

        System.out.println(savaData);
        boolean b = animeService.saveBatch(savaData);
        return null;
    }



}