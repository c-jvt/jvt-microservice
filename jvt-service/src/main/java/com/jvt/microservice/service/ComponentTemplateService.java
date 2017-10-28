package com.jvt.microservice.service;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.domain.ComponentTemplate;

public interface ComponentTemplateService {
    ResultBody getInfo(String id);
    
    ResultBody getList(String keyword, PageRequest pageRequest);
    
    ResultBody addInfo(ComponentTemplate componentTemplate);
    
    ResultBody updateInfo(ComponentTemplate componentTemplate);
    
    ResultBody delInfo(String id);
}

