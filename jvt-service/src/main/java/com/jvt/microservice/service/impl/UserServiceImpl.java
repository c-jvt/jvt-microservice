package com.jvt.microservice.service.impl;

import java.util.List;

import com.github.pagehelper.Page;
import com.jvt.microservice.infrastructure.encryption.MD5Util;
import org.springframework.stereotype.Service;
import com.jvt.microservice.domain.base.PageResult;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.infrastructure.mybatis.SqlUtil;
import com.jvt.microservice.infrastructure.mybatis.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.jvt.microservice.dao.UserDao;
import com.jvt.microservice.domain.User;
import com.jvt.microservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public ResultBody getInfo(String id) {
        User user = userDao.getInfo(id);
        ResultBody resultBody = new ResultBody(user);
        return resultBody;
    }

    public User getInfoByAccount(String account) {
        User user = userDao.getInfoByAccount(account);
        return user;
    }

    public ResultBody getList(String keyword, PageRequest pageRequest) {
        Page<?> page = PageUtil.startPageAllowNull(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<User> userList = userDao.getList(SqlUtil.likeEscapeH(keyword));
        PageResult<User> pageList = new PageResult<User>(userList, page.getTotal());
        ResultBody resultBody = new ResultBody(pageList);
        return resultBody;
    }

    public ResultBody addInfo(User user) {
        user.setSalt(user.autoSalt());
        String pwd = user.getPwd() + user.getSalt();
        user.setPwd(MD5Util.EncoderByMd5(pwd));
        int num = userDao.addInfo(user);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }

    public ResultBody updateInfo(User user) {
        user.setSalt(user.autoSalt());
        String pwd = user.getPwd() + user.getSalt();
        user.setPwd(MD5Util.EncoderByMd5(pwd));
        int num = userDao.updateInfo(user);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }

    public ResultBody delInfo(String id) {
        int num = userDao.delInfo(id);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }
}