package com.phoenixhell.boot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-下午 2:51
 */
@Component
//其他容器组件可以使用 applicationContext
public class Blue implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
        System.out.println("传入的IOC"+applicationContext);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("当前bean的名字"+s);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String s = resolver.resolveStringValue("你好${os.name} 我是#{60*60}");
        System.out.println("解析的字符串"+s);
    }
}
