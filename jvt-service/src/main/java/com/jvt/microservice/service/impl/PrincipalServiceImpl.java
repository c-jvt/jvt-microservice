package com.jvt.microservice.service.impl;

import com.jvt.microservice.dao.PrincipalDao;
import com.jvt.microservice.domain.Principal;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrincipalServiceImpl implements PrincipalService {
    @Autowired
    private PrincipalDao principalDao;

    @Override
    public ResultBody getPrincipal(String account) {
        Principal principal = principalDao.getPrincipal(account);
        ResultBody resultBody = new ResultBody(principal);
        return resultBody;
    }
}
