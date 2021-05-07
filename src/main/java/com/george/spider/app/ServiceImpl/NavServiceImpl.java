package com.george.spider.app.ServiceImpl;

import com.george.spider.app.Entity.Nav;
import com.george.spider.app.Mapper.NavMapper;
import com.george.spider.app.Service.INavService;
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
public class NavServiceImpl extends ServiceImpl<NavMapper, Nav> implements INavService {

}
