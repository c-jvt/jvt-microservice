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
import com.jvt.microservice.dao.ComponentTemplateGroupDao;
import com.jvt.microservice.domain.ComponentTemplateGroup;
import com.jvt.microservice.service.ComponentTemplateGroupService;

@Service
public class ComponentTemplateGroupServiceImpl implements ComponentTemplateGroupService{
    @Autowired
    private ComponentTemplateGroupDao componentTemplateGroupDao;
    
    public ResultBody getInfo(String id) {
        ComponentTemplateGroup componentTemplateGroup=componentTemplateGroupDao.getInfo(id);
        ResultBody resultBody = new ResultBody(componentTemplateGroup);
        return resultBody;
    }
    
    public ResultBody getList(String keyword,PageRequest pageRequest){
        Page<?> page = PageUtil.startPageAllowNull(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<ComponentTemplateGroup> componentTemplateGroupList = componentTemplateGroupDao.getList(SqlUtil.likeEscapeH(keyword));
        PageResult<ComponentTemplateGroup> pageList = new PageResult<ComponentTemplateGroup>(componentTemplateGroupList, page.getTotal());
        ResultBody resultBody = new ResultBody(pageList);
        return resultBody;
    }
    
    public ResultBody addInfo(ComponentTemplateGroup componentTemplateGroup) {
        int num = componentTemplateGroupDao.addInfo(componentTemplateGroup);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }
    
    public ResultBody updateInfo(ComponentTemplateGroup componentTemplateGroup){
        int num = componentTemplateGroupDao.updateInfo(componentTemplateGroup);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }
    
    public ResultBody delInfo(String id) {
        int num = componentTemplateGroupDao.delInfo(id);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }   
}