package com.phoenixhell.boot.ImportSelector;

import com.phoenixhell.boot.bean.Red;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-下午 3:02
 */

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean blue = registry.containsBeanDefinition("com.phoenixhell.boot.bean.Blue");
        boolean yellow = registry.containsBeanDefinition("com.phoenixhell.boot.bean.Yellow");
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Red.class);

        if(blue && yellow){
            registry.registerBeanDefinition("redssssssss",rootBeanDefinition);
        }
    }
}
