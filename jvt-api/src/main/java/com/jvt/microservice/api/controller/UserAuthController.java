package com.jvt.microservice.api.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@Api(tags = {"06 UserAuth Controller"}, description = "用户授权管理")
public class UserAuthController {

}
