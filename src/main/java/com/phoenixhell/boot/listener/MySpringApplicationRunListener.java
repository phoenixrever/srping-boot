package com.phoenixhell.boot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-上午 8:31
 */

public class MySpringApplicationRunListener implements SpringApplicationRunListener {
    private final SpringApplication application;

    private final String[] args;

//    private final SimpleApplicationEventMulticaster initialMulticaster;
    //必须要有这个构造方法 ------- java.lang.NoSuchMethodException: com.phoenixhell.boot.listener.MySpringApplicationRunListener.<init>
    // (org.springframework.boot.SpringApplication, [Ljava.lang.String;)
    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
//        this.initialMulticaster = new SimpleApplicationEventMulticaster();
//        for (ApplicationListener<?> listener : application.getListeners()) {
//            this.initialMulticaster.addApplicationListener(listener);
//        }
    }

    @Override
    public void starting() {
//        System.out.println("MySpringApplicationRunListener starting-------");

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("MySpringApplicationRunListener environmentPrepared-------");

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener contextPrepared-------");

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener contextLoaded-------");

    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener stared-------");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener running-------");

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
