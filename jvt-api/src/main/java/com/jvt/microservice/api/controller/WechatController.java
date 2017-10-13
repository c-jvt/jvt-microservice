package com.jvt.microservice.api.controller;

import com.google.gson.JsonParser;
import com.jvt.microservice.infrastructure.http.HttpRequest;
import com.jvt.microservice.infrastructure.wechat.MessageUtil;
import com.jvt.microservice.infrastructure.wechat.TextMessage;
import com.jvt.microservice.domain.property.WechatProperies;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@RestController
@RequestMapping(value = "/wechat")
@Api(tags = "99 Wechat Controller", description = "微信接口")
public class WechatController {
    @Autowired
    private WechatProperies wechatProperies;

    @ApiOperation(value = "服务验证:公众号上配置", hidden = true)
    @RequestMapping(method = RequestMethod.GET)
    public void wechatService(PrintWriter out, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "";
        /** 判断是否是微信接入激活验证，只有首次接入验证时才会收到echostr参数，此时需要把它直接返回 */
        String echostr = request.getParameter("echostr");
        if (echostr != null && echostr.length() > 1) {
            result = echostr;
            out.print(echostr);
        }
    }

    @ApiOperation(value = "自动回复：不调用", hidden = true)
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void wechatServicePost(PrintWriter out, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> map = MessageUtil.xmlToMap(request);
        // 发送方帐号（一个OpenID）
        String fromUserName = map.get("FromUserName");
        // 开发者微信号
        String toUserName = map.get("ToUserName");
        // 消息类型
        String msgType = map.get("MsgType");
        String msgContent = map.get("Content");
        // 默认回复一个"success"
        String responseMessage = "success";
        // 对消息进行处理
        if (MessageUtil.MESSAGE_TEXT.equals(msgType)) {// 文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setMsgType(MessageUtil.MESSAGE_TEXT);
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(System.currentTimeMillis());
            textMessage.setContent("hello world");
            responseMessage = MessageUtil.textMessageToXml(textMessage);
        }
        String event = map.get("Event");
        if (MessageUtil.MESSAGE_EVENT_SUBSCRIBE.equals(event)) {
            TextMessage textMessage = new TextMessage();
            textMessage.setMsgType(MessageUtil.MESSAGE_TEXT);
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(System.currentTimeMillis());
            textMessage.setContent("hello");
            responseMessage = MessageUtil.textMessageToXml(textMessage);
        }
        responseMessage = new String(responseMessage.getBytes(), "iso8859-1");
        out.print(responseMessage);
        out.flush();
        out.close();
    }

    @ApiOperation(value = "获取token")
    @RequestMapping(value = "token", method = RequestMethod.GET)
    public String getToken() {
        String tokenParam = wechatProperies.getTokenParam();
        String tokenObject = HttpRequest.sendGet("https://api.weixin.qq.com/cgi-bin/token", tokenParam);
        String token = new JsonParser().parse(tokenObject).getAsJsonObject().get("access_token").getAsString();
        return token;
    }

    @ApiOperation(value = "设置菜单")
    @RequestMapping(value = "menu", method = RequestMethod.POST)
    public String setMenu(@RequestParam(value = "param", required = true) String param) {
        String token = getToken();
        String result = HttpRequest.sendPost("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + token, param);
        return result;
    }

    @ApiOperation(value = "发送客服消息")
    @RequestMapping(value = "msessage/custom/send", method = RequestMethod.POST)
    public String sendCustomMessage(@RequestParam(value = "param", required = true) String param) {
        String token = getToken();
        String s = HttpRequest.sendPost("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + token, param);
        return s;
    }
}
