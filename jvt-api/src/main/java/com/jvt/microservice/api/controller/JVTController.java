package com.jvt.microservice.api.controller;


import com.jvt.microservice.infrastructure.annotation.SerializedField;

import com.jvt.microservice.infrastructure.img.QrCode;
import com.jvt.microservice.infrastructure.img.QrCodeLogo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;


@RestController
@RequestMapping(value = "/jvt")
@Api(tags = "01 JVT Controller", description = "JVT基础接口")
public class JVTController {

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    @SerializedField(encode = true)
    public String getToken(@RequestParam String code, @RequestParam String pwd) {
        return code + pwd;
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

