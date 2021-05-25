package com.george.spider.app.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.george.spider.app.Entity.AnimeSeries;
import com.george.spider.app.Entity.Banner;
import com.george.spider.app.Entity.RelAnimeSeries;
import com.george.spider.app.Mapper.AnimeSeriesMapper;
import com.george.spider.app.Mapper.BannerMapper;
import com.george.spider.app.Mapper.RelAnimeSeriesMapper;
import com.george.spider.app.Response.Response;
import com.george.spider.app.ServiceImpl.AnimeSeriesServiceImpl;
import com.george.spider.app.ServiceImpl.RelAnimeSeriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class IndexController extends BaseController {

    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private  AnimeSeriesMapper animeSeriesMapper;
    @Autowired
    private  AnimeSeriesServiceImpl animeSeriesService;
    @Autowired
    private RelAnimeSeriesMapper relAnimeSeriesMapper;
    @Autowired
    private RelAnimeSeriesServiceImpl relAnimeSeriesService;


    @PostMapping("banner")
    public Response<List<Banner>> getBanner(){
        List<Banner> banners = bannerMapper.selectList(null);
        return Response.success("获取成功",banners);
    }

    @PostMapping("videoList")
    public Response<ArrayList> animeList() {
        List<AnimeSeries> list = animeSeriesService.list();
        ArrayList videoList = new ArrayList();
        list.forEach(item->{
            ArrayList seriesList = new ArrayList();
            QueryWrapper<RelAnimeSeries> queryWrapper = new QueryWrapper<RelAnimeSeries>();
            queryWrapper.eq("seriesId",item.getId());
            List<RelAnimeSeries> relAnimeSeries = relAnimeSeriesMapper.selectList(queryWrapper);
            seriesList.add(0,item.getSeries());
            seriesList.add(1,relAnimeSeries);
            videoList.add(seriesList);
        });
        return Response.success("获取成功",videoList);
    }






}