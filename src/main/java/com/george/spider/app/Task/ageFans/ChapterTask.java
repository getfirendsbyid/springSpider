package com.george.spider.app.Task.ageFans;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.george.spider.app.Entity.*;
import com.george.spider.app.Entity.Anime;
import com.george.spider.app.Mapper.*;
import com.george.spider.app.ServiceImpl.*;
import com.george.spider.app.Utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ChapterTask {
    @Autowired
    private AnimeServiceImpl animeService;
    @Autowired
    private AnimeMapper animeMapper;
    @Autowired
    private AnimeArea animeArea;
    @Autowired
    private AnimeAreaMapper animeAreaMapper;
    @Autowired
    private AnimeAreaServiceImpl animeAreaService;
    @Autowired
    private AnimeLetter animeLetter;
    @Autowired
    private AnimeLetterMapper animeLetterMapper;
    @Autowired
    private AnimeLetterServiceImpl animeLetterService;
    @Autowired
    private AnimeYear animeYear;
    @Autowired
    private AnimeYearMapper animeYearMapper;
    @Autowired
    private AnimeYearServiceImpl animeYearService;
    @Autowired
    private AnimeSeason animeSeason;
    @Autowired
    private AnimeSeasonMapper animeSeasonMapper;
    @Autowired
    private AnimeSeasonServiceImpl animeSeasonService;

    public Object getList(Integer aid){
        try{
        System.out.println("thread:"+Thread.currentThread().getName());
        String url ="https://api.agefans.app/v2/detail/"+aid;
        String html = null;
        html = HttpClientUtils.httpGetRequest(url);
        System.out.println("第"+aid+"页");

        //获取数据
        String animeListString = JSON.parseObject(html).getString("AniInfo");
        JSONObject object = JSON.parseObject(animeListString);

        //获取区域id
        QueryWrapper<AnimeArea> animeAreaQueryWrapper = new QueryWrapper<>();
        animeAreaQueryWrapper.eq("area",object.getString("R地区") );
        AnimeArea animeArea = animeAreaMapper.selectOne(animeAreaQueryWrapper);
        if (animeArea==null){
            animeArea.setArea(object.getString("R地区"));
            animeArea.setUpdatedat(LocalDateTime.now());
            animeArea.setCreatedat(LocalDateTime.now());
            animeAreaMapper.insert(animeArea);
        }
        //获取首字母id
        QueryWrapper<AnimeLetter> animeLetterQueryWrapper = new QueryWrapper<>();
        animeLetterQueryWrapper.eq("letter",object.getString("R字母索引"));
        AnimeLetter animeLetter = animeLetterMapper.selectOne(animeLetterQueryWrapper);
        if (animeLetter==null){
            animeLetter.setLetter(object.getString("R地区"));
            animeLetter.setUpdatedat(LocalDateTime.now());
            animeLetter.setCreatedat(LocalDateTime.now());
            animeLetterMapper.insert(animeLetter);
        }

        //获取年份Id
        QueryWrapper<AnimeYear> animeYearQueryWrapper = new QueryWrapper<>();
        animeYearQueryWrapper.eq("year",object.getString("R首播年份"));
        AnimeYear animeYear = animeYearMapper.selectOne(animeYearQueryWrapper);
        if (animeYear==null){
            animeYear.setYear(object.getString("R首播年份"));
            animeYear.setUpdatedat(LocalDateTime.now());
            animeYear.setCreatedat(LocalDateTime.now());
            animeYearMapper.insert(animeYear);
        }
        //获取seasonId
        QueryWrapper<AnimeSeason> animeSeasonQueryWrapper = new QueryWrapper<>();
        animeSeasonQueryWrapper.eq("season",object.getString("R首播季度"));
        AnimeSeason animeSeason = animeSeasonMapper.selectOne(animeSeasonQueryWrapper);
        if (animeSeason==null){
                animeSeason.setSeason(object.getString("R首播季度"));
                animeSeason.setUpdatedat(LocalDateTime.now());
                animeSeason.setCreatedat(LocalDateTime.now());
                animeSeasonMapper.insert(animeSeason);
            }
        //其他字段
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(object.getString("R更新时间str"),df);

        UpdateWrapper<Anime> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("aId",aid).
                set("areaId",animeArea.getId()).
                set("letterId",animeLetter.getId()).
                set("videoSize",object.getString("R视频尺寸")).
                set("website",object.getString("R官方网站")).
                set("newUpdateAt",ldt).
                set("star",object.getInteger("R推荐星级")).
                set("coverImg",object.getString("R封面图")).
                set("rankCnt",object.getInteger("RankCnt")).
                set("yearId",animeYear.getId()).
                set("seasonId",animeSeason.getId()).
                set("updatedAt",LocalDateTime.now());

            int update = animeMapper.update(null, updateWrapper);
            System.out.println(update);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
