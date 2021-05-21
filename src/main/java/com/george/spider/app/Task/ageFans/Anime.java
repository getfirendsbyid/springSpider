package com.george.spider.app.Task.ageFans;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.george.spider.app.Entity.AnimeStatus;
import com.george.spider.app.Entity.AnimeType;
import com.george.spider.app.ServiceImpl.*;
import com.george.spider.app.Utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
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
    private AnimeTagServiceImpl animeTagService;
    @Autowired
    private AnimeTypeServiceImpl animeTypeService;
    @Autowired
    private AnimeStatusServiceImpl animeStatusService;

    public Future<String> getList(Integer page)  {
        System.out.println("thread:"+Thread.currentThread().getName());
        String url ="https://api.agefans.app/v2/catalog?genre=all&label=all&letter=all&order=更新时间&region=all&resource=all&season=all&status=all&year=all&page="+page+"&size=10";
        String html = null;
        html = HttpClientUtils.httpGetRequest(url);
        System.out.println("第"+page+"页");

        //获取分页数据
        String animeListString = JSON.parseObject(html).getString("AniPreL");
        List<HashMap> hashMapList = JSON.parseArray(animeListString, HashMap.class);
        System.out.println(hashMapList);

        Collection animeArray = new ArrayList();
        for (int i = 0; i < hashMapList.size(); i++) {
            com.george.spider.app.Entity.Anime anime = new com.george.spider.app.Entity.Anime();
            anime.setAid(Integer.valueOf(hashMapList.get(i).get("AID").toString()));
            anime.setName(hashMapList.get(i).get("R动画名称").toString());
            //存储typeId 索引值
            QueryWrapper<AnimeType> AnimeTypeWrapper = new QueryWrapper<>();
            AnimeTypeWrapper.eq("type",hashMapList.get(i).get("R动画类型").toString() );
            AnimeType Typeone = animeTypeService.getOne(AnimeTypeWrapper);
            anime.setTypeid(Typeone.getId());
            anime.setTruename(hashMapList.get(i).get("R原版名称").toString());
            anime.setOthername(hashMapList.get(i).get("R其他名称").toString());
            //转首播时间
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
            LocalDateTime Playtime = LocalDateTime.parse(hashMapList.get(i).get("R首播时间").toString(), fmt);
            anime.setPlaytime(Playtime);
            //存储 R播放状态
            QueryWrapper<AnimeStatus> AnimeStatusWrapper = new QueryWrapper<>();
            AnimeStatusWrapper.eq("status",hashMapList.get(i).get("R动画类型").toString());
            AnimeStatusWrapper.last("LIMIT 1");
            AnimeStatus Statusone = animeStatusService.getOne(AnimeStatusWrapper);

            anime.setStatusid(Statusone.getId());
            anime.setAuthor(hashMapList.get(i).get("R原作").toString());
            anime.setCompany(hashMapList.get(i).get("R制作公司").toString());
            anime.setDesc(hashMapList.get(i).get("R简介").toString());
            anime.setCoversmallimg(hashMapList.get(i).get("R封面图小").toString());
            anime.setLatestname(hashMapList.get(i).get("R新番标题").toString());
            animeArray.add(anime);
        }
        animeService.saveBatch(animeArray);


//
//        Collection savaData = new ArrayList();
//
//        for (Integer i =0;i<response.size(); i++){
//            com.george.spider.app.Entity.Anime animeEntity = new com.george.spider.app.Entity.Anime();
//            LocalDateTime localDateTime = LocalDateTime.ofEpochSecond( Integer.parseInt(response.get(i).get("time").toString()), 0, ZoneOffset.ofHours(8));
//            animeEntity.setUpdatedat(LocalDateTime.now());
//            animeEntity.setPlaytime(localDateTime);
//            savaData.add(animeEntity);//存储数据
//        }
//
//        System.out.println(savaData);
//        boolean b = animeService.saveBatch(savaData);
        return null;
    }



}