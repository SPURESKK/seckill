package com.codehuu.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codehuu.seckill.pojo.Goods;
import com.codehuu.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HCK
 * @since 2022-09-15
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
