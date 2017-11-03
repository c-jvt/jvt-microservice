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
import com.jvt.microservice.dao.RoleDao;
import com.jvt.microservice.domain.Role;
import com.jvt.microservice.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;
    
    public ResultBody getInfo(String id) {
        Role role=roleDao.getInfo(id);
        ResultBody resultBody = new ResultBody(role);
        return resultBody;
    }
    
    public ResultBody getList(String keyword,PageRequest pageRequest){
        Page<?> page = PageUtil.startPageAllowNull(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Role> roleList = roleDao.getList(SqlUtil.likeEscapeH(keyword));
        PageResult<Role> pageList = new PageResult<Role>(roleList, page.getTotal());
        ResultBody resultBody = new ResultBody(pageList);
        return resultBody;
    }
    
    public ResultBody addInfo(Role role) {
        int num = roleDao.addInfo(role);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }
    
    public ResultBody updateInfo(Role role){
        int num = roleDao.updateInfo(role);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }
    
    public ResultBody delInfo(String id) {
        int num = roleDao.delInfo(id);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }   
}