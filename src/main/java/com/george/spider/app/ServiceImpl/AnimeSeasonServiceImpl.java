package com.george.spider.app.ServiceImpl;

import com.george.spider.app.Entity.AnimeSeason;
import com.george.spider.app.Mapper.AnimeSeasonMapper;
import com.george.spider.app.Service.IAnimeSeasonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 动漫季度表 服务实现类
 * </p>
 *
 * @author George
 * @since 2021-05-21
 */
@Service
public class AnimeSeasonServiceImpl extends ServiceImpl<AnimeSeasonMapper, AnimeSeason> implements IAnimeSeasonService {

}
