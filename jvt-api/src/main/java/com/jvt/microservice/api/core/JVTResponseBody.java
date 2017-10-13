package com.jvt.microservice.api.core;


import com.jvt.microservice.domain.base.PageResult;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.infrastructure.annotation.SerializedField;
import com.jvt.microservice.infrastructure.encryption.DesHelper;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Field;
import java.util.*;

@Order(1)
@ControllerAdvice(basePackages = "com.jvt.microservice.api.controller")
public class JVTResponseBody implements ResponseBodyAdvice {
    //包含项
    private String[] includes = {};
    //排除项
    private String[] excludes = {};
    //是否加密
    private boolean encode = false;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //重新初始化为默认值
        includes = new String[]{};
        excludes = new String[]{};
        encode = false;
        if (obj == null) {
            return null;
        }
        if (methodParameter.getMethod().isAnnotationPresent(SerializedField.class) && obj.getClass().getName().equals("com.jvt.microservice.domain.out.ResultBody")) {
            //获取注解配置的包含和去除字段
            SerializedField serializedField = methodParameter.getMethodAnnotation(SerializedField.class);
            includes = serializedField.includes();
            excludes = serializedField.excludes();
            //是否加密
            encode = serializedField.encode();
            Object retResult = null;
            Object result = ((ResultBody) obj).getResult();
            if (result.getClass().getName().equals("com.jvt.microservice.domain.base.PageResult")) {
                List list = ((PageResult) result).getList();
                Long total = ((PageResult) result).getTotal();
                list = handleList(list);
                PageResult pageResult = new PageResult(list, total);
                retResult = pageResult;
            } else if (result instanceof List) {
                List list = (List) result;
                retResult = handleList(list);
            } else {
                retResult = handleSingleObject(result);
            }

            ResultBody resultBody = ((ResultBody) obj);
            resultBody.setResult(retResult);
            return resultBody;
        }
        return obj;
    }

    /**
     * 处理返回值是单个enity对象
     *
     * @param o
     * @return
     */
    private Object handleSingleObject(Object o) {
        Map<String, Object> map = new HashMap<String, Object>();
        //获取本身包含继承的父类
        Class clazz = o.getClass();
        List<Field> fields = new ArrayList<Field>();
        while (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        for (Field field : fields) {
            //如果未配置表示全部的都返回
            if (includes.length == 0 && excludes.length == 0) {
                String newVal = getNewVal(o, field);
                map.put(field.getName(), newVal);
            } else if (includes.length > 0) {
                //有限考虑包含字段
                if (DesHelper.isStringInArray(field.getName(), includes)) {
                    String newVal = getNewVal(o, field);
                    map.put(field.getName(), newVal);
                }
            } else {
                //去除字段
                if (excludes.length > 0) {
                    if (!DesHelper.isStringInArray(field.getName(), excludes)) {
                        String newVal = getNewVal(o, field);
                        map.put(field.getName(), newVal);
                    }
                }
            }
        }
        return map;
    }

    /**
     * 处理返回值是列表
     *
     * @param list
     * @return
     */
    private List handleList(List list) {
        List retList = new ArrayList();
        for (Object o : list) {
            Map map = (Map) handleSingleObject(o);
            retList.add(map);
        }
        return retList;
    }

    /**
     * 获取加密后的新值
     *
     * @param o
     * @param field
     * @return
     */
    private String getNewVal(Object o, Field field) {
        String newVal = "";
        try {
            field.setAccessible(true);
            Object val = field.get(o);

            if (val != null) {
                if (encode) {
                    newVal = DesHelper.encode(val.toString());
                } else {
                    newVal = val.toString();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return newVal;
    }
}
