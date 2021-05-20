package com.george.spider.app.ServiceImpl;

import com.george.spider.app.Entity.AnimeType;
import com.george.spider.app.Mapper.AnimeTypeMapper;
import com.george.spider.app.Service.IAnimeTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 动漫类型表 服务实现类
 * </p>
 *
 * @author George
 * @since 2021-05-21
 */
@Service
public class AnimeTypeServiceImpl extends ServiceImpl<AnimeTypeMapper, AnimeType> implements IAnimeTypeService {

}
