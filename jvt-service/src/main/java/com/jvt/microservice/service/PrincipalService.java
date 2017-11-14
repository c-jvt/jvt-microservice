package com.jvt.microservice.service;

import com.jvt.microservice.domain.out.ResultBody;

public interface PrincipalService {
    ResultBody getPrincipal(String account);
}
