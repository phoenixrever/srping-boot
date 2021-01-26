package com.phoenixhell.boot.config;

import com.phoenixhell.boot.bean.LifeCycleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-下午 4:23
 */
@Configuration
public class LifeCycleBeanConfig {
    /*
    单是;实例 容器帮忙销毁 多实例 容器不管理 自己调销毁方法
     */
//    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public LifeCycleBean lifeCycleBean(){
        return new LifeCycleBean();
    }
}
