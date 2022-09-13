package com.codehuu.seckill.vo;

import com.sun.istack.internal.NotNull;
import lombok.Data;

@Data
public class LoginVo {
    @NotNull
    private String mobile;

    @NotNull
    private String password;
}
