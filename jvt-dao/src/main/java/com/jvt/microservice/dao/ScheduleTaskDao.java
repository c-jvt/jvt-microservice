package com.jvt.microservice.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.jvt.microservice.domain.ScheduleTask;
public interface ScheduleTaskDao {
    ScheduleTask getInfo(@Param("id") String id);
    
    List<ScheduleTask> getList(@Param("keyword") String keyword);
    
    int addInfo(ScheduleTask scheduleTask);
    
    int updateInfo(ScheduleTask scheduleTask);
    
    int delInfo(@Param("id") String id);
}



