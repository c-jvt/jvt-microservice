package com.jvt.microservice.dao;

import com.jvt.microservice.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User getInfo(@Param("id") String id);

    User getInfoByAccount(@Param("account") String account);

    List<User> getList(@Param("keyword") String keyword);

    int addInfo(User user);

    int updateInfo(User user);

    int delInfo(@Param("id") String id);
}



