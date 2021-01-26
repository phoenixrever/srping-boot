package com.phoenixhell.boot.config;

import com.phoenixhell.boot.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import com.phoenixhell.boot.interceptor.RedisUrlCountInterceptor;

/**
 * @author phoenixhell
 * @create 2021/1/13 0013-上午 7:45
 * 不用这样 放到webmvc里面统一配置
 * 如果放到这里 先执行这里的interceptor
 */
//@Import(LoginInterceptor.class)
    @Slf4j
//@Configuration(proxyBeanMethods = false) //@copmponet 也能注册 和service @Repository 一样只是个名字
//@Component
public class InterceptorConfig implements WebMvcConfigurer {
//    @Autowired
//    private LoginInterceptor loginInterceptor;
    /**
     * filter interceptor 相同功能
     * filter servlet 原生组件 脱离spring也能用
     * interceptor spring 定义的接口 可以使用spring的自动装配
     *
     */
//    @Autowired  //下面一定要有语句不然导致下面报错
//    RedisUrlCountInterceptor redisUrlCountInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration interceptor = registry.addInterceptor(loginInterceptor);
        interceptor.addPathPatterns("/**");
//        先执行外面的configruation
        log.error("外面的");
        System.out.println("外面的");
        interceptor.excludePathPatterns("/","/login","/static");

//        registry.addInterceptor(redisUrlCountInterceptor).addPathPatterns("/**")
//        .excludePathPatterns("/","/login","/static");;
    }


}
