package com.phoenixhell.boot.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-上午 8:29
 */
//@Component 在这加不行
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("MyApplicationListener onApplicationEvent-----------start"+applicationEvent);
    }
}
