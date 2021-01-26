package com.phoenixhell.boot.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-上午 8:27
 */

public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            System.out.println("MyApplicationContextInitializer initialize------------------start");
    }
}
