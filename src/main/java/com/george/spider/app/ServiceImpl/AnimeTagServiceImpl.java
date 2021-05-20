package com.george.spider.app.ServiceImpl;

import com.george.spider.app.Entity.AnimeTag;
import com.george.spider.app.Mapper.AnimeTagMapper;
import com.george.spider.app.Service.IAnimeTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author George
 * @since 2021-05-21
 */
@Service
public class AnimeTagServiceImpl extends ServiceImpl<AnimeTagMapper, AnimeTag> implements IAnimeTagService {

}
