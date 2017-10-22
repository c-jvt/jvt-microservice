package com.jvt.microservice.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.jvt.microservice.infrastructure.encryption.Md5Util;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Service;
import com.jvt.microservice.domain.base.PageResult;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.infrastructure.mybatis.SqlUtil;
import com.jvt.microservice.infrastructure.mybatis.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.jvt.microservice.dao.AdminDao;
import com.jvt.microservice.domain.Admin;
import com.jvt.microservice.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    public ResultBody getInfo(String id) {
        Admin admin = adminDao.getInfo(id);
        ResultBody resultBody = new ResultBody(admin);
        return resultBody;
    }

    public ResultBody getList(String keyword, PageRequest pageRequest) {
        Page<?> page = PageUtil.startPageAllowNull(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Admin> adminList = adminDao.getList(SqlUtil.likeEscapeH(keyword));
        PageResult<Admin> pageList = new PageResult<Admin>(adminList, page.getTotal());
        ResultBody resultBody = new ResultBody(pageList);
        return resultBody;
    }

    public ResultBody addInfo(Admin admin) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        admin.setSalt(Admin.autoSalt());
        String pwd = admin.getPwd() + admin.getSalt();
        admin.setPwd(Md5Util.EncoderByMd5(pwd));
        int num = adminDao.addInfo(admin);

        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }

    public ResultBody updateInfo(Admin admin) {
        int num = adminDao.updateInfo(admin);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }

    public ResultBody updatePwd(String id, String oldPwd, String newPwd, String rePwd) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String salt = Admin.autoSalt();
        map.put("id", id);
        String pwd = newPwd + salt;
        map.put("pwd", pwd);
        map.put("salt", salt);
        int num = adminDao.updatePwd(map);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }


    public ResultBody delInfo(String id) {
        int num = adminDao.delInfo(id);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }


}