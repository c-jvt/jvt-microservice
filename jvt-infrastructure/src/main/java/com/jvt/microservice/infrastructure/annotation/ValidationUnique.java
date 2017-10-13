package com.jvt.microservice.infrastructure.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidationUnique {

    //参照resources里面ValidationUnique文件内的key，读取参数
    String[] key() default {};

    //是否排除本身
    boolean excludeSelf() default false;

    boolean isExistContinue() default false;

}