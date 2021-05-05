package com.george.spider.app.Service;

import com.george.spider.app.Entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author George
 * @since 2021-05-03
 */
@Mapper
@Component
public interface IUsersService extends IService<Users> {

}
