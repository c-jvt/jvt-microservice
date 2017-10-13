package com.jvt.microservice.service;


import com.jvt.microservice.domain.out.ResultBody;

public interface JVTService {

    ResultBody isFieldValueExist(String validationUniqueJSON, boolean excludeSelf, String paramValueJSON);
}
