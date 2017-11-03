package com.jvt.microservice.service;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.domain.Role;

public interface RoleService {
    ResultBody getInfo(String id);
    
    ResultBody getList(String keyword, PageRequest pageRequest);
    
    ResultBody addInfo(Role role);
    
    ResultBody updateInfo(Role role);
    
    ResultBody delInfo(String id);
}

