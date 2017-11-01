package com.jvt.microservice.api.core.oauth;


import com.jvt.microservice.infrastructure.encryption.MD5Util;
import org.springframework.security.authentication.encoding.PasswordEncoder;


/**
 * Created by linqinghuang on 2017/10/31.
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encodePassword(String rawPass, Object salt) {
        String encPass = MD5Util.EncoderByMd5(rawPass + (String) salt);
        return encPass;
    }

    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        return encPass.equalsIgnoreCase(MD5Util.EncoderByMd5(rawPass + (String) salt));
    }
}
