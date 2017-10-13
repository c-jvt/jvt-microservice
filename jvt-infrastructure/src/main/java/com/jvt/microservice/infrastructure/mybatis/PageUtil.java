package com.jvt.microservice.infrastructure.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;

public class PageUtil extends PageMethod {
    //如果分页参数为null，默认当前页1，每页条数为参数int类型的最大值
    public static <E> Page<E> startPageAllowNull(Integer pageNum, Integer pageSize) {
        Page<E> page = null;
        if (pageNum == null || pageSize == null) {
            page = new Page(1, 2147483646, true);
        } else {
            int _pageNum = new Integer(pageNum).intValue();
            int _pageSize = new Integer(pageSize).intValue();
            page = new Page(_pageNum, _pageSize, true);
        }
        setLocalPage(page);
        return page;
    }
}
