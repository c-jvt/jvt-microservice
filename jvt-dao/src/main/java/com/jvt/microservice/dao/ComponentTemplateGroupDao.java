package com.jvt.microservice.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.jvt.microservice.domain.ComponentTemplateGroup;
public interface ComponentTemplateGroupDao {
    ComponentTemplateGroup getInfo(@Param("id") String id);
    
    List<ComponentTemplateGroup> getList(@Param("keyword") String keyword);
    
    int addInfo(ComponentTemplateGroup componentTemplateGroup);
    
    int updateInfo(ComponentTemplateGroup componentTemplateGroup);
    
    int delInfo(@Param("id") String id);
}



