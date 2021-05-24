package com.george.spider.app.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.george.spider.app.Entity.Anime;
import com.george.spider.app.Mapper.AnimeMapper;
import com.george.spider.app.Task.ageFans.ChapterTask;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/task")
public class TaskController extends BaseController{
    @Autowired
    private com.george.spider.app.Task.ageFans.AnimeTask AnimeTask;
    @Autowired
    private com.george.spider.app.Task.ageFans.TagTask tagTask;
    @Autowired
    private ChapterTask chapter;

    @Autowired
    private AnimeMapper animeMapper;


    @RequestMapping("anime111")
    public long Anime()  {
        long s = System.currentTimeMillis();
        for (int i = 1; i < 1000; i++) {
            final boolean list = AnimeTask.getList(i);
        }
        long e = System.currentTimeMillis();
        System.out.println("task总耗时:" + (e - s));
        return  (e - s);
    }


    @RequestMapping("chapter")
    public long chapter()  {
        List<Anime> anime = animeMapper.selectList(new QueryWrapper<>());
        long s = System.currentTimeMillis();
        for (int i = 0; i < anime.size(); i++) {
            chapter.getList(anime.get(i).getAid());
        }
        long e = System.currentTimeMillis();
        System.out.println("task总耗时:" + (e - s));
        return  (e - s);
    }

    @SneakyThrows
    @RequestMapping("tag1212121")
    public long AnimeTag()  {
        long s = System.currentTimeMillis();
        Future<String> task1 = tagTask.start();
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
//            Future<String> task1 = animeDetailTask.getDetail(anime.get(i).getJiId());
        }

        long e = System.currentTimeMillis();
        System.out.println("task总耗时:" + (e - s));
        return  (e - s);
    }

}
