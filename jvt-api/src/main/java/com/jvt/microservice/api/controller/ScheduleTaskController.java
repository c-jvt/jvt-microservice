package com.jvt.microservice.api.controller;

import com.jvt.microservice.domain.ScheduleTask;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.service.ScheduleTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scheduleTask")
@Api(tags = {"96 ScheduleTask Controller"}, description = "任务调度接口")
public class ScheduleTaskController {
    @Autowired
    private ScheduleTaskService scheduleTaskService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据Id获取ScheduleTask信息", notes = "根据Id获取ScheduleTask信息")
     public ResultBody getScheduleTask(@PathVariable(value = "id") String id) {
        return scheduleTaskService.getInfo(id);
    }
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiOperation(value = "根据关键字获取ScheduleTask列表", notes = "根据关键字获取ScheduleTask列表")
    public ResultBody getScheduleTaskList(@RequestParam(value = "keyword", required = false) String keyword,PageRequest pageRequest) {
        return scheduleTaskService.getList(keyword,pageRequest);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增ScheduleTask", notes = "新增ScheduleTask")
    public ResultBody addScheduleTask(@RequestBody ScheduleTask scheduleTask) {
        return scheduleTaskService.addInfo(scheduleTask);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改ScheduleTask", notes = "修改ScheduleTask")
    public ResultBody updateScheduleTask(@RequestBody ScheduleTask scheduleTask) {
        return scheduleTaskService.updateInfo(scheduleTask);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除指定ID的ScheduleTask", notes = "删除指定ID的ScheduleTask")
    public ResultBody delScheduleTask(@PathVariable(value = "id") String id) {
        return scheduleTaskService.delInfo(id);
    }

    
}