package com.codehuu.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codehuu.seckill.pojo.Order;
import com.codehuu.seckill.pojo.User;
import com.codehuu.seckill.vo.GoodsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HCK
 * @since 2022-09-15
 */
public interface IOrderService extends IService<Order> {

    Order seckill(User user, GoodsVo goods);
}
