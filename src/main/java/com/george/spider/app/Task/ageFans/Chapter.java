package com.george.spider.app.Task.ageFans;

import com.alibaba.fastjson.JSON;
import com.george.spider.app.ServiceImpl.AnimeServiceImpl;
import com.george.spider.app.Utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Component
public class Chapter {
    @Autowired
    private AnimeServiceImpl animeService;

    public void getList(Integer aid){
        System.out.println("thread:"+Thread.currentThread().getName());
        String url ="https://api.agefans.app/v2/detail/"+aid;
        String html = null;
        html = HttpClientUtils.httpGetRequest(url);
        System.out.println("第"+aid+"页");

        //获取分页数据
        String animeListString = JSON.parseObject(html).getString("AniPreL");
        List<HashMap> hashMapList = JSON.parseArray(animeListString, HashMap.class);

        Collection animeArray = new ArrayList();
    }
}
