package com.jvt.microservice.api.controller;


import com.alibaba.fastjson.JSONObject;
import com.jvt.microservice.api.core.oauth.Token;
import com.jvt.microservice.domain.property.SystemProperties;
import com.jvt.microservice.infrastructure.annotation.SerializedField;

import com.jvt.microservice.infrastructure.img.QrCode;
import com.jvt.microservice.infrastructure.img.QrCodeLogo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;


@RestController
@RequestMapping(value = "/jvt")
@Api(tags = "98 JVT Controller", description = "JVT基础接口")
public class JVTController {
    @Autowired
    SystemProperties systemProperties;

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    @SerializedField(encode = true)
    public JSONObject getToken(@RequestParam String account, @RequestParam String password) throws IOException {
        Token token = new Token(systemProperties.getBasePath());
        JSONObject jo = token.getAccessToken(account, password, "test", "test");
        return jo;
    }

    @ApiOperation(value = "获取二维码", notes = "获取二维码")
    @RequestMapping(value = "/qr/code/{logo}/{content}", method = RequestMethod.GET)
    public void getQrCode(@PathVariable(value = "content") String content, @PathVariable(value = "logo") String logo,
                          HttpServletResponse response) throws Exception {
        String format = "jpeg";
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/" + format);
        /*logo==1 带logo */
        try {
            if (logo.equals("1")) {
                URL logoUrl = new URL("http://www.logosc.cn/Public/imgs/index_big.png");
                QrCodeLogo.writeToStream(content, logoUrl, "jpeg", response.getOutputStream());
            } else {
                QrCode.writeToStream(content, format, response.getOutputStream());
            }
        } catch (IOException e) {
            System.out.println("二维码写入流失败" + e.getMessage());
        }
    }

}

