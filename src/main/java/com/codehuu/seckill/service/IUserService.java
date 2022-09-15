package com.codehuu.seckill.service;

import com.codehuu.seckill.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codehuu.seckill.vo.LoginVo;
import com.codehuu.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HCK
 * @since 2022-09-13
 */
public interface IUserService extends IService<User> {
    /**
     * 登录功能
     * @param loginVo
     * @param request
     * @param response
     * @return
     */
    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据cookie从redis获取用户信息
     * @param request
     * @param response
     * @param ticket
     * @return
     */
    User getUserByCookie(HttpServletRequest request, HttpServletResponse response, String ticket);
}
