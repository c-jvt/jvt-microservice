package com.jvt.microservice.api.core.interceptor;


import com.google.gson.Gson;
import com.jvt.microservice.api.controller.JVTController;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.infrastructure.annotation.ValidationUnique;
import com.jvt.microservice.infrastructure.enums.GlobalErrorInfoEnum;
import com.jvt.microservice.service.JVTService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class MyHandlerInterceptor implements HandlerInterceptor {

    private final JVTService jvtService;

    public MyHandlerInterceptor(JVTService jvtService) {
        this.jvtService = jvtService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {


        //验证是否登录||权限

        //自定义字段是否存在验证
        if (((HandlerMethod) handler).getMethod().isAnnotationPresent(ValidationUnique.class)) {
            //获取注解配置的包含和去除字段
            ValidationUnique validationUnique = ((HandlerMethod) handler).getMethodAnnotation(ValidationUnique.class);

            String[] key = validationUnique.key();
            boolean excludeSelf = validationUnique.excludeSelf();
            boolean isExistContinue = validationUnique.isExistContinue();
            String paramValueJSON = request.getAttribute("_validationUnique").toString();

            String validationUniqueJSON = getValidationUniqueInfo("ValidationUnique.properties", key[0]);
            ResultBody resultBody = jvtService.isFieldValueExist(validationUniqueJSON, excludeSelf, paramValueJSON);

            //存在不继续||不存在不继续
            if ((isExistContinue && resultBody.getCode().equals(GlobalErrorInfoEnum.FIELD_VALUE_NOT_EXIST.getCode()))
                    || (!isExistContinue && resultBody.getCode().equals(GlobalErrorInfoEnum.FIELD_VALUE_EXIST.getCode()))) {
                Gson gs = new Gson();
                String data = gs.toJson(resultBody);
                OutputStream outputStream = response.getOutputStream();//获取OutputStream输出流
                response.setHeader("content-type", "text/html;charset=UTF-8");
                byte[] dataByteArr = data.getBytes("UTF-8");//将字符转换成字节数组，指定以UTF-8编码进行转换
                outputStream.write(dataByteArr);//使用OutputStream流向客户端输出字节数组
                return false;
            }
        }

        System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    public static String getValidationUniqueInfo(String fileNamePath, String key) throws IOException {
        Properties props = new Properties();
        InputStream in = null;
        try {
            // 必须要将.Properties文件和此class类文件放在同一个包中
            in = JVTController.class.getClassLoader().getResourceAsStream(fileNamePath);
            props.load(in);
            String value = props.getProperty(key);
            // 有乱码时要进行重新编码
            // new String(props.getProperty("key").getBytes("ISO-8859-1"), "GBK");
            return value;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (null != in)
                in.close();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }

}
