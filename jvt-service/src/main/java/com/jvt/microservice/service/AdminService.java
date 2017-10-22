package com.jvt.microservice.service;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.domain.Admin;

public interface AdminService {
    ResultBody getInfo(String id);
    
    ResultBody getList(String keyword, PageRequest pageRequest);
    
    ResultBody addInfo(Admin admin);
    
    ResultBody updateInfo(Admin admin);
    
    ResultBody delInfo(String id);
}

