package com.phoenixhell.boot.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author phoenixhell
 * @create 2021/1/13 0013-下午 4:03
 */
//@Configuration
public class ServletRegistConfig {
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new MyServlet(),"/my","/my02");
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        MyFilter myFilter = new MyFilter();
//        return  new FilterRegistrationBean(myFilter,servletRegistrationBean());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
         filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","my02"));
        return  filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        MyservletContextListener contextListener = new MyservletContextListener();
        return  new ServletListenerRegistrationBean(contextListener);
    }
}
