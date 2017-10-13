package com.jvt.microservice.api.controller;

import com.jvt.microservice.domain.Menu;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/menu")
@Api(tags = {"03 Menu Controller"}, description = "Menu接口")
public class MenuController {
    @Autowired
    private MenuService menuService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据Id获取Menu信息", notes = "根据Id获取Menu信息")
     public ResultBody getMenu(@PathVariable(value = "id") String id) {
        return menuService.getInfo(id);
    }
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiOperation(value = "根据关键字获取Menu列表", notes = "根据关键字获取Menu列表")
    public ResultBody getMenuList(@RequestParam(value = "keyword", required = false) String keyword,PageRequest pageRequest) {
        return menuService.getList(keyword,pageRequest);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增Menu", notes = "新增Menu")
    public ResultBody addMenu(@RequestBody Menu menu) {
        return menuService.addInfo(menu);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改Menu", notes = "修改Menu")
    public ResultBody updateMenu(@RequestBody Menu menu) {
        return menuService.updateInfo(menu);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除指定ID的Menu", notes = "删除指定ID的Menu")
    public ResultBody delMenu(@PathVariable(value = "id") String id) {
        return menuService.delInfo(id);
    }

    
}