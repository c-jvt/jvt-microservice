package com.jvt.microservice.api.core.oauth;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

public class Token {
    private String url;
    private final static String getAccessTokenUrl = "/oauth/token";

    public Token(String url) {
        this.url = url;
    }

    public JSONObject getAccessToken(String username, String password, String id, String secret) throws IOException {
        // 设置代理服务器地址和端口
        HttpClient client = new HttpClient();
        // 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https
        //HttpMethod method=new GetMethod("http://java.sun.com");
        //使用POST方法
        PostMethod method = new PostMethod(url + getAccessTokenUrl);
        String auth = id + ":" + secret;
        String code = Base64.encodeBase64String(auth.getBytes("UTF-8"));
        System.out.println(code);
        method.addRequestHeader("Authorization", "Basic " + code);
        method.addRequestHeader("Access-Control-Allow-Origin", "*");
        method.addRequestHeader("Access-Control-Allow-Credentials", "true");
        method.addRequestHeader("Access-Control-Allow-Methods", "POST");
        method.addParameter("grant_type", "password");
/*        method.addParameter("scope", "read,write");*/
        method.addParameter("username", username);
        method.addParameter("password", password);
        client.executeMethod(method);
        //打印服务器返回的状态
        System.out.println(method.getStatusLine());
        //打印返回的信息
        System.out.println(method.getResponseBodyAsString());
        //释放连接
        method.releaseConnection();
        JSONObject jo = (JSONObject) JSONObject.parse(method.getResponseBodyAsString());
        return jo;
    }
}
