package com.jvt.microservice.domain;
import com.jvt.microservice.domain.base.MasterEntity;

public class ComponentTemplate extends MasterEntity {
    //组件名称
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
    //组件HTML模板路径
    private String htmlTemplateUrl;
    public String getHtmlTemplateUrl(){
        return this.htmlTemplateUrl;
    }
    public void setHtmlTemplateUrl(String htmlTemplateUrl){
        this.htmlTemplateUrl=htmlTemplateUrl;
    }
    //组件样式模板路径
    private String styleTemplateUrl;
    public String getStyleTemplateUrl(){
        return this.styleTemplateUrl;
    }
    public void setStyleTemplateUrl(String styleTemplateUrl){
        this.styleTemplateUrl=styleTemplateUrl;
    }
    //组件脚本参数路径
    private String jsParamTemplateUrl;
    public String getJsParamTemplateUrl(){
        return this.jsParamTemplateUrl;
    }
    public void setJsParamTemplateUrl(String jsParamTemplateUrl){
        this.jsParamTemplateUrl=jsParamTemplateUrl;
    }
    //组件效果图片路径
    private String imageUrl;
    public String getImageUrl(){
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl=imageUrl;
    }
    //分组ID
    private String groupId;
    public String getGroupId(){
        return this.groupId;
    }
    public void setGroupId(String groupId){
        this.groupId=groupId;
    }
}