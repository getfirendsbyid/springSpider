package com.george.spider.app.ServiceImpl;

import com.george.spider.app.Entity.AnimeLetter;
import com.george.spider.app.Mapper.AnimeLetterMapper;
import com.george.spider.app.Service.IAnimeLetterService;
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
public class AnimeLetterServiceImpl extends ServiceImpl<AnimeLetterMapper, AnimeLetter> implements IAnimeLetterService {

}
