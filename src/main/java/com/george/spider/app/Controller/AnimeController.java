package com.george.spider.app.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.george.spider.app.Entity.Anime;
import com.george.spider.app.Mapper.AnimeMapper;
import com.george.spider.app.Request.Anime.ListValidator;
import com.george.spider.app.Response.Response;
import com.george.spider.app.ServiceImpl.AnimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/anime")
public class AnimeController {

    @Autowired
    private AnimeMapper animeMapper;
    @Autowired
    private AnimeServiceImpl animeService;

    @PostMapping("list")
    public Response<List<Anime>> getHomeList(@Validated ListValidator listValidator, BindingResult result){
        Integer page = listValidator.getPage();
        Integer pageSize = listValidator.getPageSize();
        if(result.hasErrors()){
            String errorMsg = result.getFieldError().getDefaultMessage();
            return Response.error(errorMsg);
        }
        IPage<Anime> pageWhere = new Page<>(page, pageSize);//参数一是当前页，参数二是每页个数
        IPage<Anime> animeData = animeMapper.selectPage(pageWhere, null);
        List<Anime> listData = animeData.getRecords();
        return Response.success("获取成功",listData);
    }
}
