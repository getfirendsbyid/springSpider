package com.george.spider.app.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.george.spider.app.Entity.Anime;
import com.george.spider.app.Mapper.AnimeMapper;
import com.george.spider.app.Task.Ji.AnimeDetailTask;
import com.george.spider.app.Task.Ji.AnimeTask;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/task")
public class TaskController extends BaseController{
    @Autowired
    private AnimeTask AnimeTask;

    @Autowired
    private AnimeDetailTask animeDetailTask;

    @Autowired
    private AnimeMapper animeMapper;


    @SneakyThrows
    @RequestMapping("anime")
    public long Anime()  {
        long s = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Future<String> task1 = AnimeTask.getAnime(i);
        }
        long e = System.currentTimeMillis();
        System.out.println("task总耗时:" + (e - s));
        return  (e - s);
    }

    @SneakyThrows
    @RequestMapping("detail")
    public long getDetail(){
        List<Anime> anime = animeMapper.selectList(new QueryWrapper<>());

        long s = System.currentTimeMillis();
        for (int i = 0; i < anime.size(); i++) {
            Future<String> task1 = animeDetailTask.getDetail(anime.get(i).getJiId());
        }

        long e = System.currentTimeMillis();
        System.out.println("task总耗时:" + (e - s));
        return  (e - s);
    }

}
