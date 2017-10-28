package com.jvt.microservice.api.controller;

import com.jvt.microservice.domain.ComponentTemplate;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.service.ComponentTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/componentTemplate")
@Api(tags = {"04 ComponentTemplate Controller"}, description = "组件模板接口")
public class ComponentTemplateController {
    @Autowired
    private ComponentTemplateService componentTemplateService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据Id获取ComponentTemplate信息", notes = "根据Id获取ComponentTemplate信息")
     public ResultBody getComponentTemplate(@PathVariable(value = "id") String id) {
        return componentTemplateService.getInfo(id);
    }
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiOperation(value = "根据关键字获取ComponentTemplate列表", notes = "根据关键字获取ComponentTemplate列表")
    public ResultBody getComponentTemplateList(@RequestParam(value = "keyword", required = false) String keyword,PageRequest pageRequest) {
        return componentTemplateService.getList(keyword,pageRequest);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增ComponentTemplate", notes = "新增ComponentTemplate")
    public ResultBody addComponentTemplate(@RequestBody ComponentTemplate componentTemplate) {
        return componentTemplateService.addInfo(componentTemplate);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改ComponentTemplate", notes = "修改ComponentTemplate")
    public ResultBody updateComponentTemplate(@RequestBody ComponentTemplate componentTemplate) {
        return componentTemplateService.updateInfo(componentTemplate);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除指定ID的ComponentTemplate", notes = "删除指定ID的ComponentTemplate")
    public ResultBody delComponentTemplate(@PathVariable(value = "id") String id) {
        return componentTemplateService.delInfo(id);
    }

    
}