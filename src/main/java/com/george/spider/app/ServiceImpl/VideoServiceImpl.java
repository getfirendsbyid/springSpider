package com.george.spider.app.ServiceImpl;

import com.george.spider.app.Entity.Video;
import com.george.spider.app.Mapper.VideoMapper;
import com.george.spider.app.Service.IVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author George
 * @since 2021-05-03
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

}
