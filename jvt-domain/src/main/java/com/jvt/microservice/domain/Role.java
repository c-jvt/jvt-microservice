package com.jvt.microservice.domain;
import com.jvt.microservice.domain.base.BaseEntity;
public class Role extends BaseEntity {
    //名称
    private String name;
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
}