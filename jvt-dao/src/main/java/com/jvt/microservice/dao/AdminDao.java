package com.jvt.microservice.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import com.jvt.microservice.domain.Admin;

public interface AdminDao {
    Admin getInfo(@Param("id") String id);

    List<Admin> getList(@Param("keyword") String keyword);

    int addInfo(Admin admin);

    int updateInfo(Admin admin);

    int updatePwd(Map<String, Object> map);

    int delInfo(@Param("id") String id);
}



