package com.jvt.microservice.api.controller;

import com.jvt.microservice.domain.User;
import com.jvt.microservice.domain.base.PageRequest;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.infrastructure.annotation.ValidationUnique;
import com.jvt.microservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
@Api(tags = {"03 User Controller"}, description = "用户管理接口")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据Id获取User信息", notes = "根据用户ID获取用户信息")
    public ResultBody getUser(@PathVariable(value = "id") String id) {
        return userService.getInfo(id);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiOperation(value = "根据关键字获取User列表", notes = "根据关键字获取User列表")
    public ResultBody getUserList(@RequestParam(value = "keyword", required = false) String keyword, PageRequest pageRequest) {
        return userService.getList(keyword, pageRequest);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增User", notes = "新增User")
    @ValidationUnique(key = {"user.code"}, excludeSelf = false, isExistContinue = false)
    public ResultBody addUser(@Valid @RequestBody User user) {
        return userService.addInfo(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改User", notes = "修改User")
    public ResultBody updateUser(@RequestBody User user) {
        return userService.updateInfo(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除指定ID的User", notes = "删除指定ID的User")
    public ResultBody delUser(@PathVariable(value = "id") String id) {
        return userService.delInfo(id);
    }


}