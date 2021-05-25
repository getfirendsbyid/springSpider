package com.george.spider.app.ServiceImpl;

import com.george.spider.app.Entity.Banner;
import com.george.spider.app.Mapper.BannerMapper;
import com.george.spider.app.Service.IBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author George
 * @since 2021-05-25
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {

}
