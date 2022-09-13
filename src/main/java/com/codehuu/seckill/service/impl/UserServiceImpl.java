package com.codehuu.seckill.service.impl;

import com.codehuu.seckill.pojo.User;
import com.codehuu.seckill.mapper.UserMapper;
import com.codehuu.seckill.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HCK
 * @since 2022-09-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
