package com.jvt.microservice.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.jvt.microservice.domain.User;
public interface UserDao {
    User getInfo(@Param("id") String id);

    List<User> getList(@Param("keyword") String keyword);

    int addInfo(User user);

    int updateInfo(User user);

    int delInfo(@Param("id") String id);
}



