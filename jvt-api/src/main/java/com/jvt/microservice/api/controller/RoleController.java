package com.jvt.microservice.api.controller;

import com.jvt.microservice.domain.Role;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/role")
@Api(tags = {"Role Controller"}, description = "Role接口")
public class RoleController {
    @Autowired
    private RoleService roleService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据Id获取Role信息", notes = "根据Id获取Role信息")
     public ResultBody getRole(@PathVariable(value = "id") String id) {
        return roleService.getInfo(id);
    }
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiOperation(value = "根据关键字获取Role列表", notes = "根据关键字获取Role列表")
    public ResultBody getRoleList(@RequestParam(value = "keyword", required = false) String keyword,PageRequest pageRequest) {
        return roleService.getList(keyword,pageRequest);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增Role", notes = "新增Role")
    public ResultBody addRole(@RequestBody Role role) {
        return roleService.addInfo(role);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改Role", notes = "修改Role")
    public ResultBody updateRole(@RequestBody Role role) {
        return roleService.updateInfo(role);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除指定ID的Role", notes = "删除指定ID的Role")
    public ResultBody delRole(@PathVariable(value = "id") String id) {
        return roleService.delInfo(id);
    }

    
}