package com.jvt.microservice.service;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.domain.Menu;

public interface MenuService {
    ResultBody getInfo(String id);
    
    ResultBody getList(String keyword, PageRequest pageRequest);
    
    ResultBody addInfo(Menu menu);
    
    ResultBody updateInfo(Menu menu);
    
    ResultBody delInfo(String id);
}

