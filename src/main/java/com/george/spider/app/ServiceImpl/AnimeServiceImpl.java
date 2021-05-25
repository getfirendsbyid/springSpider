package com.george.spider.app.ServiceImpl;

import com.george.spider.app.Entity.Anime;
import com.george.spider.app.Mapper.AnimeMapper;
import com.george.spider.app.Service.IAnimeService;
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
public class AnimeServiceImpl extends ServiceImpl<AnimeMapper, Anime> implements IAnimeService {

}
