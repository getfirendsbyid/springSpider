package com.george.spider.app.ServiceImpl;

import com.george.spider.app.Entity.AnimeStatus;
import com.george.spider.app.Mapper.AnimeStatusMapper;
import com.george.spider.app.Service.IAnimeStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 动漫连载状态表 服务实现类
 * </p>
 *
 * @author George
 * @since 2021-05-21
 */
@Service
public class AnimeStatusServiceImpl extends ServiceImpl<AnimeStatusMapper, AnimeStatus> implements IAnimeStatusService {

}
