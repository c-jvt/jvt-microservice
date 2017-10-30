package com.jvt.microservice.service.impl;

import java.util.List;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import com.jvt.microservice.domain.base.PageResult;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.infrastructure.mybatis.SqlUtil;
import com.jvt.microservice.infrastructure.mybatis.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.jvt.microservice.dao.ScheduleTaskDao;
import com.jvt.microservice.domain.ScheduleTask;
import com.jvt.microservice.service.ScheduleTaskService;

@Service
public class ScheduleTaskServiceImpl implements ScheduleTaskService{
    @Autowired
    private ScheduleTaskDao scheduleTaskDao;
    
    public ResultBody getInfo(String id) {
        ScheduleTask scheduleTask=scheduleTaskDao.getInfo(id);
        ResultBody resultBody = new ResultBody(scheduleTask);
        return resultBody;
    }
    
    public ResultBody getList(String keyword,PageRequest pageRequest){
        Page<?> page = PageUtil.startPageAllowNull(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<ScheduleTask> scheduleTaskList = scheduleTaskDao.getList(SqlUtil.likeEscapeH(keyword));
        PageResult<ScheduleTask> pageList = new PageResult<ScheduleTask>(scheduleTaskList, page.getTotal());
        ResultBody resultBody = new ResultBody(pageList);
        return resultBody;
    }
    
    public ResultBody addInfo(ScheduleTask scheduleTask) {
        int num = scheduleTaskDao.addInfo(scheduleTask);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }
    
    public ResultBody updateInfo(ScheduleTask scheduleTask){
        int num = scheduleTaskDao.updateInfo(scheduleTask);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }
    
    public ResultBody delInfo(String id) {
        int num = scheduleTaskDao.delInfo(id);
        ResultBody resultBody = new ResultBody(num);
        return resultBody;
    }   
}