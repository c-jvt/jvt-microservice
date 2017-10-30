package com.jvt.microservice.domain;
import com.jvt.microservice.domain.base.MasterEntity;

public class ScheduleTask extends MasterEntity {
    //调度任务名称
    private String name;
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    //路由
    private String url;
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url){
        this.url=url;
    }
    //路由ACTION 类型
    private int actionType;
    public int getActionType(){
        return this.actionType;
    }
    public void setActionType(int actionType){
        this.actionType=actionType;
    }
    //单次型任务：0；重复型任务：1
    private int type;
    public int getType(){
        return this.type;
    }
    public void setType(int type){
        this.type=type;
    }
    //时间类型：天|周|月|年
    private int dateType;
    public int getDateType(){
        return this.dateType;
    }
    public void setDateType(int dateType){
        this.dateType=dateType;
    }
    //调度配置内容
    private String content;
    public String getContent(){
        return this.content;
    }
    public void setContent(String content){
        this.content=content;
    }
    //时间类型：天|周|月|年
    private String rule;
    public String getRule(){
        return this.rule;
    }
    public void setRule(String rule){
        this.rule=rule;
    }
}