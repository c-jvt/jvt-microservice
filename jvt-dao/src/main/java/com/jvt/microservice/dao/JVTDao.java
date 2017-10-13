package com.jvt.microservice.dao;

import java.util.HashMap;
import java.util.Map;

public interface JVTDao {
    //验证字段值是否存在
    int isFieldValueExist(Map<String, Object> map);
}
