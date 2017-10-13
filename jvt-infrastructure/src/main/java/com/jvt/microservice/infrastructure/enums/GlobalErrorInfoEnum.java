package com.jvt.microservice.infrastructure.enums;

public enum GlobalErrorInfoEnum {
    SUCCESS("0", "success"),//成功
    NOT_FOUND("-1", "not found"),//找不到
    FIELD_VALUE_EXIST("5", "the field value exist"),
    FIELD_VALUE_NOT_EXIST("10", "the field value not exist"),
    PARAMTER_VALIDATION("15", "invalid parameter validation"),//无效的请求参数
    NOT_PERMISSION("20", "not permissions"),//没有权限
    SYSTEM_EXCEPTION("99", "system throw exception");//系统异常

    private String code;
    private String message;

    GlobalErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
