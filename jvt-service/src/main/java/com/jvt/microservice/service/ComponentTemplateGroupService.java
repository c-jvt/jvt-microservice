package com.jvt.microservice.service;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.domain.ComponentTemplateGroup;

public interface ComponentTemplateGroupService {
    ResultBody getInfo(String id);
    
    ResultBody getList(String keyword, PageRequest pageRequest);
    
    ResultBody addInfo(ComponentTemplateGroup componentTemplateGroup);
    
    ResultBody updateInfo(ComponentTemplateGroup componentTemplateGroup);
    
    ResultBody delInfo(String id);
}

