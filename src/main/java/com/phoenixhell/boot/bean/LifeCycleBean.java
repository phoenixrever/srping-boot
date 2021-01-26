package com.phoenixhell.boot.bean;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-下午 4:21
 */

public class LifeCycleBean {
    public LifeCycleBean() {
        System.out.println("LifeCycleBean constructor");
    }

    public void init(){
        System.out.println("LifeCycleBean init");
    }

    public void destroy(){
        System.out.println("LifeCycleBean destroy");
    }
}
