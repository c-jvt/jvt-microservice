package com.jvt.microservice.infrastructure.encryption;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    /**
     * 利用MD5进行加密
     *
     * @param str 待加密的字符串
     * @return 加密后的字符串
     */
    public static String EncoderByMd5(String str) {
        //确定计算方法
        String newStr = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            newStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (Exception ex) {

        }
        return newStr;
    }
}
