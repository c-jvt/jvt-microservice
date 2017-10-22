package com.jvt.microservice.service.impl;

import java.util.List;
import com.github.pagehelper.Page;
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
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;
    
    public ResultBody getInfo(String id) {
        Admin admin=adminDao.getInfo(id);
        ResultBody resultBody = new ResultBody(admin);
        return resultBody;
    }
    
    public ResultBody getList(String keyword,PageRequest pageRequest){
        Page<?> page = PageUtil.startPageAllowNull(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Admin> adminList = adminDao.getList(SqlUtil.likeEscapeH(keyword));
        PageResult<Admin> pageList = new PageResult<Admin>(adminList, page.getTotal());
        ResultBody resultBody = new ResultBody(pageList);
        return resultBody;
    }
    
    public ResultBody addInfo(Admin admin) {
        int num = adminDao.addInfo(admin);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }
    
    public ResultBody updateInfo(Admin admin){
        int num = adminDao.updateInfo(admin);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }
    
    public ResultBody delInfo(String id) {
        int num = adminDao.delInfo(id);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }   
}