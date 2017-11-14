package com.jvt.microservice.dao;

import com.jvt.microservice.domain.Principal;
import org.apache.ibatis.annotations.Param;

public interface PrincipalDao {
    Principal getPrincipal(@Param("account") String account);
}
