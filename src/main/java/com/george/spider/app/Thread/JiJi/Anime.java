package com.george.spider.app.Thread.JiJi;

import com.alibaba.fastjson.JSON;

import com.george.spider.app.ServiceImpl.AnimeServiceImpl;
import com.george.spider.app.Utils.HttpClientUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.*;

@RestController
public class Anime implements Runnable{

    @Autowired
    private AnimeServiceImpl animeService;


    @Override
    public void run() {
        String url ="http://api.jijiweb.cn/v1/anime/anime_list.php";
        Map<String, Object> object = new HashMap<>();
        object.put("year","全部年份");
        object.put("where","全部地区");
        object.put("tag","全部标签");
        object.put("page_long","100");
        object.put("page_num",1);
        String html = null;
        try {
            html = HttpClientUtils.httpPostRequest(url,object);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<HashMap> response = JSON.parseArray(JSON.parseObject(html).getString("list"), HashMap.class);

        com.george.spider.app.Entity.Anime animeEntity = new com.george.spider.app.Entity.Anime();
        Collection savaData = new ArrayList();

        for (Integer i =0;i<response.size(); i++){
            animeEntity.setAnime(response.get(i).get("name").toString());
//            animeEntity.setAnime(listdata.get("cover").toString());
            savaData.add(animeEntity);
//            animeEntity.setAnime(listdata.get("tag").toString());
        }
        System.out.println(savaData);
        boolean b = animeService.saveBatch(savaData);

    }
}

