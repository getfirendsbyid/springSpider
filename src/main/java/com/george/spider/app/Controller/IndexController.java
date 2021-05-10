package com.george.spider.app.Controller;


import com.george.spider.app.Mapper.BannerMapper;
import com.george.spider.app.Mapper.SeriseMapper;
import com.george.spider.app.Task.Ji.AnimeTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class IndexController extends BaseController {

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private SeriseMapper seriseMapper;

    @Autowired
    private AnimeTask AnimeTask;

//    @RequestMapping("banner")
//    public String getBanner(){
//        Result result = new Result();
//        List<Banner> banners = bannerMapper.selectList(null);
//        return result;
//    }
//
//    @RequestMapping("serise")
//    public String getSerise(){
//        List<Serise> serise = seriseMapper.selectList(null);
//        return success("获取成功",serise);
//    }
//
//
//    @RequestMapping("animeList")
//    public String getHomeList(){
//        IPage<Serise> userPage = new Page<>(2, 2);//参数一是当前页，参数二是每页个数
//        IPage<Serise> seriseIPage = seriseMapper.selectPage(userPage, null);
//        List<HashMap> hashMaps = JSONObject.parseArray(seriseIPage.toString(), HashMap.class);
//        return success("获取成功",hashMaps);
//    }


}