package com.codehuu.seckill.service.impl;

import com.codehuu.seckill.exception.GlobalException;
import com.codehuu.seckill.pojo.User;
import com.codehuu.seckill.mapper.UserMapper;
import com.codehuu.seckill.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codehuu.seckill.utils.CookieUtil;
import com.codehuu.seckill.utils.MD5Util;
import com.codehuu.seckill.utils.UUIDUtil;
import com.codehuu.seckill.vo.LoginVo;
import com.codehuu.seckill.vo.RespBean;
import com.codehuu.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

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
    @Autowired UserMapper userMapper;
    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        User user = userMapper.selectById(mobile);
        //没有查到用户
        if(user == null){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        //密码不匹配
        if(!user.getPassword().equals(MD5Util.formPassTODbPass(password,user.getSlat()))){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        //登录成功生成cookie
        String ticket = UUIDUtil.uuid();
        request.getSession().setAttribute(ticket,user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success();
    }
}
