package com.jvt.microservice.api.controller;

import com.jvt.microservice.domain.ComponentTemplateGroup;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.service.ComponentTemplateGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/componentTemplateGroup")
@Api(tags = {"03 ComponentTemplateGroup Controller"}, description = "组件模板分组接口")
public class ComponentTemplateGroupController {
    @Autowired
    private ComponentTemplateGroupService componentTemplateGroupService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据Id获取ComponentTemplateGroup信息", notes = "根据Id获取ComponentTemplateGroup信息")
     public ResultBody getComponentTemplateGroup(@PathVariable(value = "id") String id) {
        return componentTemplateGroupService.getInfo(id);
    }
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiOperation(value = "根据关键字获取ComponentTemplateGroup列表", notes = "根据关键字获取ComponentTemplateGroup列表")
    public ResultBody getComponentTemplateGroupList(@RequestParam(value = "keyword", required = false) String keyword,PageRequest pageRequest) {
        return componentTemplateGroupService.getList(keyword,pageRequest);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增ComponentTemplateGroup", notes = "新增ComponentTemplateGroup")
    public ResultBody addComponentTemplateGroup(@RequestBody ComponentTemplateGroup componentTemplateGroup) {
        return componentTemplateGroupService.addInfo(componentTemplateGroup);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改ComponentTemplateGroup", notes = "修改ComponentTemplateGroup")
    public ResultBody updateComponentTemplateGroup(@RequestBody ComponentTemplateGroup componentTemplateGroup) {
        return componentTemplateGroupService.updateInfo(componentTemplateGroup);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除指定ID的ComponentTemplateGroup", notes = "删除指定ID的ComponentTemplateGroup")
    public ResultBody delComponentTemplateGroup(@PathVariable(value = "id") String id) {
        return componentTemplateGroupService.delInfo(id);
    }

    
}