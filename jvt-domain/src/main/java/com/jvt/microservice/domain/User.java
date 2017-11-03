package com.jvt.microservice.domain;

import com.jvt.microservice.domain.base.MasterEntity;

import java.util.Random;

public class User extends MasterEntity {
    //编码 or 账号
    private String code;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    //名称
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //密码
    private String pwd;

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    //加密盐
    private String salt;

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    //邮箱
    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //用户角色ID
    private String roleId;

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public static String autoSalt() {
        String _salt = "";
        // 可选字符
        String codes = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        for (int i = 0; i < 8; i++) {//循环四次，每次生成一个字符
            int index = r.nextInt(codes.length());
            char s = codes.charAt(index);
            _salt += s;
        }
        return _salt;
    }
}