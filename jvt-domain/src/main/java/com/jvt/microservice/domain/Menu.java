package com.jvt.microservice.domain;
import com.jvt.microservice.domain.base.MasterEntity;
public class Menu extends MasterEntity {
    //编码
    private String code;
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code=code;
    }
    //名称
    private String name;
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    //是否启用图标
    private int hasIcon;
    public int getHasIcon(){
        return this.hasIcon;
    }
    public void setHasIcon(int hasIcon){
        this.hasIcon=hasIcon;
    }
    //图标路径
    private String iconUrl;
    public String getIconUrl(){
        return this.iconUrl;
    }
    public void setIconUrl(String iconUrl){
        this.iconUrl=iconUrl;
    }
    //菜单路径
    private String url;
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url){
        this.url=url;
    }
    //父节点ID
    private String pid;
    public String getPid(){
        return this.pid;
    }
    public void setPid(String pid){
        this.pid=pid;
    }
}