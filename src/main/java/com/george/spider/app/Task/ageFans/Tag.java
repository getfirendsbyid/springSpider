package com.george.spider.app.Task.ageFans;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.george.spider.app.Entity.AnimeArea;
import com.george.spider.app.Entity.AnimeTag;
import com.george.spider.app.Mapper.AnimeAreaMapper;
import com.george.spider.app.ServiceImpl.*;
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

public class Tag {

    @Autowired
    private AnimeAreaServiceImpl animeAreaService;
    @Autowired
    private AnimeTypeServiceImpl animeTypeService;
    @Autowired
    private AnimeLetterServiceImpl animeLetterService;
    @Autowired
    private AnimeYearServiceImpl animeYearService;
    @Autowired
    private AnimeSeasonServiceImpl animeSeasonService;
    @Autowired
    private AnimeStatusServiceImpl animeStatusService;
    @Autowired
    private AnimeTagServiceImpl animeTagService;

    @Async
    public Future<String> start()  {
        System.out.println("thread:"+Thread.currentThread().getName());
        String url ="https://api.agefans.app/v2/catalog?genre=all&label=all&letter=all&order=更新时间&region=all&resource=all&season=all&status=all&year=all&page=0&size=10";
        String html = null;
        html = HttpClientUtils.httpGetRequest(url);
        System.out.println(html);
        //存储区域
        String labels_region = JSON.parseObject(html).getString("Labels_region");
        JSONArray objects = JSON.parseArray(labels_region);
        Collection AreaData = new ArrayList();
        for (int i = 0; i < objects.size(); i++) {
            if (i>1){
                com.george.spider.app.Entity.AnimeArea animeArea = new com.george.spider.app.Entity.AnimeArea();
                animeArea.setArea(objects.get(i).toString());
                animeArea.setCreatedat(LocalDateTime.now());
                animeArea.setUpdatedat(LocalDateTime.now());
                AreaData.add(animeArea);
            }
        }
        animeAreaService.saveBatch(AreaData);
        //存储动漫类型
        String Labels_genre = JSON.parseObject(html).getString("Labels_genre");
        JSONArray typeObjects = JSON.parseArray(Labels_genre);
        Collection typeData = new ArrayList();
        for (int i = 0; i < typeObjects.size(); i++) {
            if (i>1){
                com.george.spider.app.Entity.AnimeType animeType = new com.george.spider.app.Entity.AnimeType();
                animeType.setType(objects.get(i).toString());
                animeType.setCreatedat(LocalDateTime.now());
                animeType.setUpdatedat(LocalDateTime.now());
                typeData.add(animeType);
            }
        }
        animeTypeService.saveBatch(typeData);

        //存储动漫首字母
        String Labels_letter = JSON.parseObject(html).getString("Labels_letter");
        JSONArray letterObjects = JSON.parseArray(Labels_letter);
        Collection letterData = new ArrayList();
        for (int i = 0; i < letterObjects.size(); i++) {
            if (i>1){
                com.george.spider.app.Entity.AnimeLetter animeLetter = new com.george.spider.app.Entity.AnimeLetter();
                animeLetter.setLetter(objects.get(i).toString());
                animeLetter.setCreatedat(LocalDateTime.now());
                animeLetter.setUpdatedat(LocalDateTime.now());
                letterData.add(animeLetter);
            }
        }
        animeLetterService.saveBatch(letterData);
        //存储动漫年份
        String Labels_year = JSON.parseObject(html).getString("Labels_year");
        JSONArray yearObjects = JSON.parseArray(Labels_year);
        Collection yearData = new ArrayList();
        for (int i = 0; i < yearObjects.size(); i++) {
            if (i>1){
                com.george.spider.app.Entity.AnimeYear animeYear = new com.george.spider.app.Entity.AnimeYear();
                animeYear.setYear(objects.get(i).toString());
                animeYear.setCreatedat(LocalDateTime.now());
                animeYear.setUpdatedat(LocalDateTime.now());
                yearData.add(animeYear);
            }
        }
        animeYearService.saveBatch(yearData);
        //存储动漫季度
        String Labels_season = JSON.parseObject(html).getString("Labels_season");
        JSONArray seasonObjects = JSON.parseArray(Labels_season);
        Collection seasonData = new ArrayList();
        for (int i = 0; i < seasonObjects.size(); i++) {
            if (i>1){
                com.george.spider.app.Entity.AnimeSeason animeSeason = new com.george.spider.app.Entity.AnimeSeason();
                animeSeason.setSeason(objects.get(i).toString());
                animeSeason.setCreatedat(LocalDateTime.now());
                animeSeason.setUpdatedat(LocalDateTime.now());
                seasonData.add(animeSeason);
            }
        }
        animeSeasonService.saveBatch(seasonData);
        //存储动漫连载状态
        String Labels_status = JSON.parseObject(html).getString("Labels_status");
        JSONArray statusObjects = JSON.parseArray(Labels_status);
        Collection statusData = new ArrayList();
        for (int i = 0; i < statusObjects.size(); i++) {
            if (i>1){
                com.george.spider.app.Entity.AnimeStatus animeStatus = new com.george.spider.app.Entity.AnimeStatus();
                animeStatus.setStatus(objects.get(i).toString());
                animeStatus.setCreatedat(LocalDateTime.now());
                animeStatus.setUpdatedat(LocalDateTime.now());
                statusData.add(animeStatus);
            }
        }
        animeStatusService.saveBatch(statusData);
        //存储动漫tag
        String Labels_label = JSON.parseObject(html).getString("Labels_label");
        JSONArray tagObjects = JSON.parseArray(Labels_label);
        Collection tagData = new ArrayList();
        for (int i = 0; i < tagObjects.size(); i++) {
            if (i>1){
                com.george.spider.app.Entity.AnimeTag animeTag = new com.george.spider.app.Entity.AnimeTag();
                animeTag.setTag(objects.get(i).toString());
                animeTag.setCreatedat(LocalDateTime.now());
                animeTag.setUpdatedat(LocalDateTime.now());
                tagData.add(animeTag);
            }
        }
        animeTagService.saveBatch(tagData);

        return null;
    }
}
