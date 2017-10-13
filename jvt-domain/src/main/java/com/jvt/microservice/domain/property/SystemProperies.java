package com.jvt.microservice.domain.property;

public class SystemProperies {
    //token加密盐
    private String tokenSalt;

    public String getTokenSalt() {
        return this.tokenSalt;
    }

    public void setTokenSalt(String tokenSalt) {
        this.tokenSalt = tokenSalt;
    }

    private Long tokenLimit;

    public Long getTokenLimit() {
        return tokenLimit;
    }

    public void setTokenLimit(Long tokenLimit) {
        this.tokenLimit = tokenLimit;
    }
}
