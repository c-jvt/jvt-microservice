package com.jvt.microservice.domain.base;

import java.util.UUID;

public class BaseEntity {

    //主键
    private String id;

    public String getId() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

