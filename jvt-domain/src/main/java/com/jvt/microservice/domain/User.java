package com.jvt.microservice.domain;

import com.jvt.microservice.domain.base.MasterEntity;
import org.hibernate.validator.constraints.NotEmpty;

public class User extends MasterEntity {
    //编码 or 账号
    @NotEmpty(message = "{user.code.NotEmpty}")
    private String code;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    //名称
    @NotEmpty(message = "{user.name.NotEmpty}")
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

    //邮箱
    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}