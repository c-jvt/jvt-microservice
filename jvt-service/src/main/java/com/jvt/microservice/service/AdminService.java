package com.jvt.microservice.service;

import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.domain.Admin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public interface AdminService {
    ResultBody getInfo(String id);

    ResultBody getList(String keyword, PageRequest pageRequest);

    ResultBody addInfo(Admin admin) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    ResultBody updateInfo(Admin admin);

    ResultBody updatePwd(String id, String oldPwd, String newPwd, String rePwd);

    ResultBody delInfo(String id);
}

