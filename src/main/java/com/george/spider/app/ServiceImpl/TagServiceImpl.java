package com.george.spider.app.ServiceImpl;

import com.george.spider.app.Entity.Tag;
import com.george.spider.app.Mapper.TagMapper;
import com.george.spider.app.Service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author George
 * @since 2021-05-07
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
