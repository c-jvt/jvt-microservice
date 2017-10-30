package com.jvt.microservice.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.jvt.microservice.domain.Menu;
public interface MenuDao {
    Menu getInfo(@Param("id") String id);
    
    List<Menu> getList(@Param("keyword") String keyword);
    
    int addInfo(Menu menu);
    
    int updateInfo(Menu menu);
    
    int delInfo(@Param("id") String id);
}



