package com.jvt.microservice.domain.base;

import java.util.Date;

public class MasterEntity extends BaseEntity {

    //状态
    private int state;

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return this.state;
    }

    //排序
    private Integer sort;

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSort() {
        return this.sort;
    }

    //记录添加时间
    private Date addTime;

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getAddTime() {
        return this.addTime;
    }

    //记录新增人编码
    private String fkAddUserId;

    public void setFkAddUserId(String fkAddUserId) {
        this.fkAddUserId = fkAddUserId;
    }

    public String getFkAddUserId() {
        return fkAddUserId;
    }

    //记录新增人名称
    private String fkAddUserName;

    public void setFkAddUserName(String fkAddUserName) {
        this.fkAddUserName = fkAddUserName;
    }

    public String getFkAddUserName() {
        return this.fkAddUserName;
    }


}
