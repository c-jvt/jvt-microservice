package com.jvt.microservice.service;

import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.domain.User;

public interface UserService {
    ResultBody getInfo(String id);

    ResultBody getList(String keyword, PageRequest pageRequest);

    ResultBody addInfo(User user);

    ResultBody updateInfo(User user);

    ResultBody delInfo(String id);
}

