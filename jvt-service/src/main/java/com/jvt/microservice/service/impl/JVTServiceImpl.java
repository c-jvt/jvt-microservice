package com.jvt.microservice.service.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jvt.microservice.dao.JVTDao;
import com.jvt.microservice.domain.out.ResultBody;
import com.jvt.microservice.infrastructure.enums.GlobalErrorInfoEnum;
import com.jvt.microservice.service.JVTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JVTServiceImpl implements JVTService {

    @Autowired
    private JVTDao jvtDao;

    public ResultBody isFieldValueExist(String validationUniqueJSON, boolean excludeSelf, String paramValueJSON) {
        ResultBody resultBody = new ResultBody();
        JsonObject validationUniqueInfo = new JsonParser().parse(validationUniqueJSON).getAsJsonObject();//获取验证配置
        JsonObject paramValueInfo = new JsonParser().parse(paramValueJSON).getAsJsonObject();//获取参数

        int _excludeSelf = excludeSelf ? 1 : 0;

        String table = validationUniqueInfo.get("table").getAsString();
        String column = validationUniqueInfo.get("column").getAsString();
        String field = validationUniqueInfo.get("field").getAsString();
        String columnValue = paramValueInfo.get(field).getAsString();//获取列对应的值


        String primaryKeyColumn = validationUniqueInfo.get("primaryKeyColumn").getAsString();//主键列
        String primaryKey = validationUniqueInfo.get("primaryKey").getAsString();
        String primaryKeyValue = "";
        if (paramValueInfo.has(primaryKey)) {
            primaryKeyValue = paramValueInfo.get(primaryKey).getAsString();//获取主键对应的值
        }


        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("table", table);
        map.put("column", column);
        map.put("columnValue", columnValue);
        map.put("primaryKeyColumn", primaryKeyColumn);
        map.put("primaryKeyValue", primaryKeyValue);

        map.put("excludeSelf", _excludeSelf);

        int num = jvtDao.isFieldValueExist(map);
        if (num > 0) {
            //字段存在
            String existMsg = validationUniqueInfo.get("existMsg").getAsString();
            resultBody.setCode(GlobalErrorInfoEnum.FIELD_VALUE_EXIST.getCode());
            //resultBody.setMessage(GlobalErrorInfoEnum.FIELD_VALUE_EXIST.getMessage());
            resultBody.setMessage(existMsg);
        } else {
            //字段不存在的消息
            String nonExistMsg = validationUniqueInfo.get("nonExistMsg").getAsString();
            resultBody.setCode(GlobalErrorInfoEnum.FIELD_VALUE_NOT_EXIST.getCode());
            //resultBody.setMessage(GlobalErrorInfoEnum.FIELD_VALUE_NOT_EXIST.getMessage());
            resultBody.setMessage(nonExistMsg);
        }
        return resultBody;
    }


}
