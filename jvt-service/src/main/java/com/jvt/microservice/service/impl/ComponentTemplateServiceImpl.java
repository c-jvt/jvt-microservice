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
import com.jvt.microservice.dao.ComponentTemplateDao;
import com.jvt.microservice.domain.ComponentTemplate;
import com.jvt.microservice.service.ComponentTemplateService;

@Service
public class ComponentTemplateServiceImpl implements ComponentTemplateService{
    @Autowired
    private ComponentTemplateDao componentTemplateDao;
    
    public ResultBody getInfo(String id) {
        ComponentTemplate componentTemplate=componentTemplateDao.getInfo(id);
        ResultBody resultBody = new ResultBody(componentTemplate);
        return resultBody;
    }
    
    public ResultBody getList(String keyword,PageRequest pageRequest){
        Page<?> page = PageUtil.startPageAllowNull(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<ComponentTemplate> componentTemplateList = componentTemplateDao.getList(SqlUtil.likeEscapeH(keyword));
        PageResult<ComponentTemplate> pageList = new PageResult<ComponentTemplate>(componentTemplateList, page.getTotal());
        ResultBody resultBody = new ResultBody(pageList);
        return resultBody;
    }
    
    public ResultBody addInfo(ComponentTemplate componentTemplate) {
        int num = componentTemplateDao.addInfo(componentTemplate);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }
    
    public ResultBody updateInfo(ComponentTemplate componentTemplate){
        int num = componentTemplateDao.updateInfo(componentTemplate);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }
    
    public ResultBody delInfo(String id) {
        int num = componentTemplateDao.delInfo(id);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }   
}