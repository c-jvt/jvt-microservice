package com.jvt.microservice.api.controller;

import com.jvt.microservice.infrastructure.http.HttpRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@Api(tags = "98 API Controller", description = "API 管理中心")
public class ApiController {
    @ApiOperation(value = "获取平台内部API列表", notes = "获取平台内部API列表")
    @RequestMapping(value = "/inner/api", method = RequestMethod.GET)
    public Object getInnerAPI() {
        return HttpRequest.sendGet("http://localhost:8080/v2/api-docs", null);

    }
}
