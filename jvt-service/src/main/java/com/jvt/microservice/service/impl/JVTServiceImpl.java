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
        JsonObject validationUniqueInfo = new JsonParser().parse(validationUniqueJSON).getAsJsonObject();
        JsonObject paramValueInfo = new JsonParser().parse(paramValueJSON).getAsJsonObject();
        String table = validationUniqueInfo.get("table").getAsString();
        String primaryKey = validationUniqueInfo.get("primaryKey").getAsString();
        String column = validationUniqueInfo.get("column").getAsString();
        String primaryKeyValue = paramValueInfo.get(primaryKey).getAsString();
        String columnValue = paramValueInfo.get(column).getAsString();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("table", table);
        map.put("column", column);
        map.put("primaryKey", primaryKey);
        map.put("primaryKeyValue", primaryKeyValue);
        map.put("columnValue", columnValue);
        int _excludeSelf = excludeSelf ? 1 : 0;
        map.put("excludeSelf", _excludeSelf);
        int num = jvtDao.isFieldValueExist(map);
        if (num > 0) {
            resultBody.setCode(GlobalErrorInfoEnum.FIELD_VALUE_EXIST.getCode());
            resultBody.setMessage(GlobalErrorInfoEnum.FIELD_VALUE_EXIST.getMessage());
        } else {
            resultBody.setCode(GlobalErrorInfoEnum.FIELD_VALUE_NOT_EXIST.getCode());
            resultBody.setMessage(GlobalErrorInfoEnum.FIELD_VALUE_NOT_EXIST.getMessage());
        }
        return resultBody;
    }


}
