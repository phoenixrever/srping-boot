package com.phoenixhell.boot.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-下午 4:34
 */
//@Component
public class LifeCycleBean2 implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean LifeCycleBean2");
    }

    //init
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet init LifeCycleBean2");
    }
}
