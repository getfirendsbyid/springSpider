package com.george.spider.app.ServiceImpl;

import com.george.spider.app.Entity.Users;
import com.george.spider.app.Mapper.UsersMapper;
import com.george.spider.app.Service.IUsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
