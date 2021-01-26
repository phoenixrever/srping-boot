package com.phoenixhell.boot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * @author phoenixhell
 * @create 2021/1/21 0021-上午 9:26
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("postProcessBeanDefinitionRegistry_____________________before postProcessBeanFactory ");
//        RootBeanDefinition beanDefinition = new RootBeanDefinition(RootBean.class);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(RootBean.class).getBeanDefinition();
        registry.registerBeanDefinition("rootBean",beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory in postProcessBeanDefinitionRegistry  ");

    }
}
