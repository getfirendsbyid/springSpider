package com.george.spider.app.ServiceImpl;

import com.george.spider.app.Entity.AnimeSeries;
import com.george.spider.app.Mapper.AnimeSeriesMapper;
import com.george.spider.app.Service.IAnimeSeriesService;
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
public class AnimeSeriesServiceImpl extends ServiceImpl<AnimeSeriesMapper, AnimeSeries> implements IAnimeSeriesService {

}
