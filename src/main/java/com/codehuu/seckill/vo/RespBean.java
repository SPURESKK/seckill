package com.codehuu.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回结果
     * @return
     */
    public static RespBean success(){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     * @param obj
     * @return
     */
    public static RespBean success(Object obj){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), obj);
    }

    /**
     * 失败返回结果
     * @param beanEnum
     * 参数传RespBeanEnum类是因为error都种类比较多
     * @return
     */
    public static RespBean error(RespBeanEnum beanEnum){
        return new RespBean(beanEnum.getCode(), beanEnum.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param beanEnum
     * @param obj
     * @return
     */
    public static RespBean error(RespBeanEnum beanEnum, Object obj){
        return new RespBean(beanEnum.getCode(), beanEnum.getMessage(), obj);
    }
}
