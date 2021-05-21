package com.george.spider.app.Controller;

import com.george.spider.app.Entity.Banner;
import com.george.spider.app.Entity.Serise;
import com.george.spider.app.Mapper.BannerMapper;
import com.george.spider.app.Mapper.SeriseMapper;
import com.george.spider.app.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/home")
public class IndexController extends BaseController {

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private SeriseMapper seriseMapper;


    @PostMapping("banner")
    public Response<List<Banner>> getBanner(){
        List<Banner> banners = bannerMapper.selectList(null);
        return Response.success("获取成功",banners);
    }

    @PostMapping("serise")
    public Response<List<Serise>> getSerise(){
        List<Serise> serise = seriseMapper.selectList(null);
        return Response.success("获取成功",serise);
    }

    public static void launch() {

    }






}