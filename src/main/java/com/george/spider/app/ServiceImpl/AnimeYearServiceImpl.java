package com.george.spider.app.ServiceImpl;

import com.george.spider.app.Entity.AnimeYear;
import com.george.spider.app.Mapper.AnimeYearMapper;
import com.george.spider.app.Service.IAnimeYearService;
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
public class AnimeYearServiceImpl extends ServiceImpl<AnimeYearMapper, AnimeYear> implements IAnimeYearService {

}
