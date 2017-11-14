package com.jvt.microservice.api.controller;

import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.service.PrincipalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/principal")
@Api(tags = {"Principal Controller"}, description = "Principal接口")
public class PrincipalController {
    @Autowired
    private PrincipalService principalService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "根据Id获取User信息", notes = "根据Id获取User信息")
    public ResultBody getPrincipal() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String account = userDetails.getUsername();
        return principalService.getPrincipal(account);
    }
}
