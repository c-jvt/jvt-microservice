package com.jvt.microservice.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.jvt.microservice.domain.ComponentTemplate;
public interface ComponentTemplateDao {
    ComponentTemplate getInfo(@Param("id") String id);
    
    List<ComponentTemplate> getList(@Param("keyword") String keyword);
    
    int addInfo(ComponentTemplate componentTemplate);
    
    int updateInfo(ComponentTemplate componentTemplate);
    
    int delInfo(@Param("id") String id);
}



