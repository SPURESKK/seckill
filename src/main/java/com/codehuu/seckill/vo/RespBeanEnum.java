package com.codehuu.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    //通用状态
    SUCCESS(200,"请求成功"),
    ERROR(500,"请求异常"),
    //登录状态
    LOGIN_ERROR(500210, "用户名或密码不正确"),
    MOBILE_ERROR(500211, "手机号码格式不正确"),

    BIND_ERROR(500212, "参数校验异常"),

    EMPTY_STOCK(500500,"库存不足"),
    REPEATE_ERROR(500501, "该商品每人限购一件");

    private final Integer code;
    private final String message;
}
