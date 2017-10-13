package com.jvt.microservice.domain.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by linqinghuang on 2017/9/9.
 */
public class PageResult<T> {
    public PageResult() {
    }

    public PageResult(List list, Long total) {
        this.list = list;
        this.total = total;
    }

    //实体列表
    private List<T> list;

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    //总条数
    public Long total;

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
