package com.codehuu.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Util {
    //加盐
    private static final String salt = "q7w8a4s5z1x2";
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    /**
     * 对输入的密码进行第一层MD5加密
     * @param inputPass
     */
    public static String inputPassToFormPass(String inputPass){
        //增加安全性
        inputPass = "" +salt.charAt(0) + salt.charAt(3) + inputPass + salt.charAt(7);
        return md5(inputPass);
    }

    /**
     * 将从前端传入的md5加密后的密码进行二次加密存入数据库
     * @param formPass
     * @param salt
     * @return
     */
    public static String formPassTODbPass(String formPass, String salt){
        formPass = "" +salt.charAt(0) + salt.charAt(3) + formPass + salt.charAt(7);
        return md5(formPass);
    }

    public static String inputPassToDbPass(String inputPass,String salt){
        String formPass = inputPassToFormPass(inputPass);
        String dbPass =  formPassTODbPass(formPass,salt);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFormPass("123456"));
        System.out.println(formPassTODbPass("ef963bed3ad24f34feaec0b8a26317f6","q7w8a4s5z1x2"));
        System.out.println(inputPassToDbPass("123456","q7w8a4s5z1x2"));
    }
}
