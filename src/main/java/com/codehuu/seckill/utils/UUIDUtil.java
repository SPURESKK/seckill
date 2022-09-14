package com.codehuu.seckill.utils;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @since 1.0.0
 */
public class UUIDUtil {

   public static String uuid() {
      return UUID.randomUUID().toString().replace("-", "");
   }

}