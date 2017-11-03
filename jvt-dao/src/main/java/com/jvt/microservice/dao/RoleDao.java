package com.jvt.microservice.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.jvt.microservice.domain.Role;
public interface RoleDao {
    Role getInfo(@Param("id") String id);
    
    List<Role> getList(@Param("keyword") String keyword);
    
    int addInfo(Role role);
    
    int updateInfo(Role role);
    
    int delInfo(@Param("id") String id);
}



