package com.phoenixhell.boot;

import com.phoenixhell.boot.bean.Boss;
import com.phoenixhell.boot.bean.Dept;
import com.phoenixhell.boot.bean.MoreBean;
import com.phoenixhell.boot.bean.User;
import com.phoenixhell.boot.config.ConfigClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author phoenixhell
 * @create 2021/1/9 0009-上午 9:40
 */
@Slf4j
@ServletComponentScan(basePackages = "com.phoenixhell.boot")
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
@MapperScan("com.phoenixhell.boot.mapper")
/*@SpringBootConfiguration
@EnableAutoConfiguration
-----@AutoConfigurationPackage  boot包下所有组件导入
-----@Import(AutoConfigurationImportSelector.class)
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })*/
//@ComponentScan(value="com",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})})
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class);
        User bean1 = run.getBean(User.class);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println("******"+beanDefinitionName+"******");
//        }
        //不加&为color 加了为colorFactoryBean
        Object bean = run.getBean("&colorFactoryBean");
        Object moreBean1 = run.getBean(MoreBean.class);
        Boss boss = run.getBean(Boss.class);
//        Object moreBean2 = run.getBean("moreBean2");
//        System.out.println(moreBean2);
        System.out.println(boss);
//        run.getEnvironment().getPropertySources();
//        Dept bean2 = run.getBean(Dept.class);

//        User bean2 = run.getBean(User.class);
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//        ConfigClass bean = run.getBean(ConfigClass.class);

//        boolean oldBean = run.containsBean("oldbean");
//        System.out.println(oldBean);
//        log.error("lombok------------"+bean2);
//        System.out.println(bean1);
        run.publishEvent(new ApplicationEvent(new String("eventString 自定义发布事件")) {

        });

//        run.close();//关闭事件
    }
}
