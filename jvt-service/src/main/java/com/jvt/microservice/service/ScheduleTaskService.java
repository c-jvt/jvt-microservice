package com.jvt.microservice.service;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.domain.ScheduleTask;

public interface ScheduleTaskService {
    ResultBody getInfo(String id);
    
    ResultBody getList(String keyword, PageRequest pageRequest);
    
    ResultBody addInfo(ScheduleTask scheduleTask);
    
    ResultBody updateInfo(ScheduleTask scheduleTask);
    
    ResultBody delInfo(String id);
}

