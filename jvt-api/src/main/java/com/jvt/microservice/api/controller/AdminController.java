package com.jvt.microservice.api.controller;

import com.jvt.microservice.domain.Admin;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.infrastructure.annotation.ValidationUnique;
import com.jvt.microservice.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/admin")
@Api(tags = {"02 Admin Controller"}, description = "Admin接口")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据Id获取Admin信息", notes = "根据Id获取Admin信息")
    public ResultBody getAdmin(@PathVariable(value = "id") String id) {
        return adminService.getInfo(id);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiOperation(value = "根据关键字获取Admin列表", notes = "根据关键字获取Admin列表")

    public ResultBody getAdminList(@RequestParam(value = "keyword", required = false) String keyword, PageRequest pageRequest) {
        return adminService.getList(keyword, pageRequest);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增Admin", notes = "新增Admin")

    @ValidationUnique(key = {"admin.code", "admin.email"}, excludeSelf = false, isExistContinue = false)

    public ResultBody addAdmin(@Valid @RequestBody Admin admin) {
        return adminService.addInfo(admin);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改Admin", notes = "修改Admin")
    @Valid
    @ValidationUnique(key = {"admin.code", "admin.email"}, excludeSelf = true, isExistContinue = false)

    public ResultBody updateAdmin(@Valid @RequestBody Admin admin) {
        return adminService.updateInfo(admin);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除指定ID的Admin", notes = "删除指定ID的Admin")
    public ResultBody delAdmin(@PathVariable(value = "id") String id) {
        return adminService.delInfo(id);
    }


}