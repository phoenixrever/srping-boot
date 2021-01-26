package com.phoenixhell.boot.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-下午 4:41
 */
//@Component
public class LifeCycleBean3 {
    public LifeCycleBean3() {
        System.out.println("LifeCycleBean3 constructor");
    }

    @PostConstruct //对象创建并赋值之后调用
    public void init(){
        System.out.println("LifeCycleBean3 init PostConstruct");
    }
    @PreDestroy //容器移除对象之前
    public void destroy(){
        System.out.println("LifeCycleBean3 PreDestroy destroy");
    }
}
