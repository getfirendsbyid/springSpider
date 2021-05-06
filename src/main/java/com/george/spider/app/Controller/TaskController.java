package com.george.spider.app.Controller;

import com.george.spider.app.Task.Ji.AnimeTask;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/task")
public class TaskController extends BaseController{
    @Autowired
    private com.george.spider.app.Task.Ji.AnimeTask AnimeTask;

    @SneakyThrows
    @RequestMapping("")
    public long Anime()  {
        long s = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Future<String> task1 = AnimeTask.getAnime(i);
        }
        long e = System.currentTimeMillis();
        System.out.println("task总耗时:" + (e - s));
        return  (e - s);
    }

    public long getDetail(){
        long s = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Future<String> task1 = AnimeTask.getAnime(i);
        }
        long e = System.currentTimeMillis();
        System.out.println("task总耗时:" + (e - s));
        return  (e - s);
    }

}
