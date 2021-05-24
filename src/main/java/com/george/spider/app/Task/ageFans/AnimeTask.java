package com.george.spider.app.Task.ageFans;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.george.spider.app.Entity.AnimeStatus;
import com.george.spider.app.Entity.AnimeType;
import com.george.spider.app.ServiceImpl.*;
import com.george.spider.app.Utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


@Component
public class AnimeTask {

    @Autowired
    private AnimeServiceImpl animeService;
    @Autowired
    private AnimeTagServiceImpl animeTagService;
    @Autowired
    private AnimeTypeServiceImpl animeTypeService;
    @Autowired
    private AnimeStatusServiceImpl animeStatusService;

    public boolean getList(Integer page)  {
        System.out.println("thread:"+Thread.currentThread().getName());
        String url ="https://api.agefans.app/v2/catalog?genre=all&label=all&letter=all&order=更新时间&region=all&resource=all&season=all&status=all&year=all&page="+page+"&size=100";
        String html = null;
        html = HttpClientUtils.httpGetRequest(url);
        System.out.println("第"+page+"页");

        //获取分页数据
        String animeListString = JSON.parseObject(html).getString("AniPreL");
        List<HashMap> hashMapList = JSON.parseArray(animeListString, HashMap.class);

        Collection animeArray = new ArrayList();
        for (int i = 0; i < hashMapList.size(); i++) {
            com.george.spider.app.Entity.Anime anime = new com.george.spider.app.Entity.Anime();
            anime.setAid(Integer.valueOf(hashMapList.get(i).get("AID").toString()));
            anime.setName(hashMapList.get(i).get("R动画名称").toString());
            //存储typeId 索引值
            QueryWrapper<AnimeType> AnimeTypeWrapper = new QueryWrapper<>();
            AnimeTypeWrapper.eq("type",hashMapList.get(i).get("R动画种类").toString() );
            AnimeType Typeone = animeTypeService.getOne(AnimeTypeWrapper);
            if (Typeone==null){
                AnimeType animeType = new AnimeType();
                animeType.setType(hashMapList.get(i).get("R动画种类").toString());
                animeType.setCreatedat(LocalDateTime.now());
                animeTypeService.save(animeType);

                anime.setTypeid(animeType.getId());
            }else {
                anime.setTypeid(Typeone.getId());
            }
            anime.setTruename(hashMapList.get(i).get("R原版名称").toString());
            anime.setOthername(hashMapList.get(i).get("R其他名称").toString());
            //转首播时间
            anime.setPlaytime(hashMapList.get(i).get("R首播时间").toString());
            //存储 R播放状态
            QueryWrapper<AnimeStatus> AnimeStatusWrapper = new QueryWrapper<>();
            AnimeStatusWrapper.eq("status",hashMapList.get(i).get("R播放状态").toString());
            AnimeStatusWrapper.last("LIMIT 1");
            AnimeStatus Statusone = animeStatusService.getOne(AnimeStatusWrapper);

            anime.setStatusid(Statusone.getId());
            anime.setAuthor(hashMapList.get(i).get("R原作").toString());
            anime.setCompany(hashMapList.get(i).get("R制作公司").toString());
            anime.setDesctext(hashMapList.get(i).get("R简介").toString());
            anime.setCoversmallimg(hashMapList.get(i).get("R封面图小").toString());
            anime.setLatestname(hashMapList.get(i).get("R新番标题").toString());
            anime.setCreatedat(LocalDateTime.now());
            try{
                boolean b = animeService.save(anime);

            }catch (Exception e){
                System.out.println(anime);
                System.out.println(e);
            }
//            animeArray.add(anime);
        }
//        try{
//            boolean b = animeService.saveBatch(animeArray);
//            System.out.println(b);
//            return b;
//        }catch (Exception e){
//            System.out.println(e);
//        }

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
        return true;
    }



}