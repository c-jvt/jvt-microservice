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
import com.jvt.microservice.dao.MenuDao;
import com.jvt.microservice.domain.Menu;
import com.jvt.microservice.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuDao menuDao;
    
    public ResultBody getInfo(String id) {
        Menu menu=menuDao.getInfo(id);
        ResultBody resultBody = new ResultBody(menu);
        return resultBody;
    }
    
    public ResultBody getList(String keyword,PageRequest pageRequest){
        Page<?> page = PageUtil.startPageAllowNull(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Menu> menuList = menuDao.getList(SqlUtil.likeEscapeH(keyword));
        PageResult<Menu> pageList = new PageResult<Menu>(menuList, page.getTotal());
        ResultBody resultBody = new ResultBody(pageList);
        return resultBody;
    }
    
    public ResultBody addInfo(Menu menu) {
        int num = menuDao.addInfo(menu);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }
    
    public ResultBody updateInfo(Menu menu){
        int num = menuDao.updateInfo(menu);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }
    
    public ResultBody delInfo(String id) {
        int num = menuDao.delInfo(id);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }   
}