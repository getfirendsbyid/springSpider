package com.george.spider.app.Task.Ji;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.george.spider.app.Entity.Anime;
import com.george.spider.app.Entity.Tag;
import com.george.spider.app.Mapper.AnimeMapper;
import com.george.spider.app.Mapper.TagMapper;
import com.george.spider.app.ServiceImpl.AnimeServiceImpl;
import com.george.spider.app.ServiceImpl.TagServiceImpl;
import com.george.spider.app.Utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.Future;


@Component
public class AnimeDetailTask {

    @Autowired
    private AnimeMapper animeMapper;
    @Autowired
    private TagServiceImpl tagService;
    @Autowired
    private TagMapper tagMapper;

    @Async
    public Future<String> getDetail(Integer id)  {
        String url ="http://api.jijiweb.cn/v1/anime/anime_data.php";
        Map<String, Object> object = new HashMap<>();
        object.put("id",id);
        String html = null;
        try {
            html = HttpClientUtils.httpPostRequest(url,object);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JSONObject response = JSON.parseObject(html);
        UpdateWrapper<Anime> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id).set("sign", response.get("sign").toString());
        int anime = animeMapper.update(null,updateWrapper);
        List<HashMap> tagList = JSON.parseArray(response.get("tag").toString(), HashMap.class);
        for (int i = 0; i < tagList.size(); i++) {
            UpdateWrapper<Tag> tagWrapper = new UpdateWrapper<>();
            updateWrapper.eq("tag", tagList.get(i).toString());
            Tag tagOneData = tagMapper.selectOne(tagWrapper);
            if (tagOneData==null){
                Tag tagEntity = new Tag();
                tagEntity.setTag(tagList.get(i).toString());
                tagEntity.setCreatedat(LocalDateTime.now());
                tagEntity.setUpdatedat(LocalDateTime.now());
                int insert = tagMapper.insert(tagEntity);

            }


        }
        return null;
    }

    /**
     * @author puyf
     * @Description:Collection中去重并将集合转为List
     * @param datas
     * @return
     */
    public static <T> List<T> distinct(Collection<T> datas) {
        if(datas == null){
            return new ArrayList<>();
        }
        Set<T> set = new HashSet<>(datas);//使用HashSet构造方法去重
        return new ArrayList<>(set);
    }

}