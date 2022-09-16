package com.codehuu.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codehuu.seckill.pojo.Goods;
import com.codehuu.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HCK
 * @since 2022-09-15
 */
public interface IGoodsService extends IService<Goods> {

    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
