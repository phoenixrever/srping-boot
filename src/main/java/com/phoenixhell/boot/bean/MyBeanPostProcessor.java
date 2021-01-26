package com.phoenixhell.boot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.thymeleaf.postprocessor.PostProcessor;

/**
 * @author phoenixhell
 * @create 2021/1/18 0018-上午 9:15
 */

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization>>>>>>>>>>>>>>>>>>>"+bean.getClass());
        return null;//返回null不会执行后面的BeanPostProcessor
    }

    //销毁
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization<<<<<<<<<<<<<<<<<"+bean.getClass());
        return bean;
    }
}
