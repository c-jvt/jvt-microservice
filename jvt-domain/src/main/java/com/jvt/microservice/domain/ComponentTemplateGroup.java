package com.jvt.microservice.domain;
import com.jvt.microservice.domain.base.MasterEntity;
public class ComponentTemplateGroup extends MasterEntity {
    //分组名称
    private String name;
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    //组件描述
    private String descr;
    public String getDescr(){
        return this.descr;
    }
    public void setDescr(String descr){
        this.descr=descr;
    }
    //分组类型
    private int type;
    public int getType(){
        return this.type;
    }
    public void setType(int type){
        this.type=type;
    }
    //父级分组ID
    private String pid;
    public String getPid(){
        return this.pid;
    }
    public void setPid(String pid){
        this.pid=pid;
    }
}