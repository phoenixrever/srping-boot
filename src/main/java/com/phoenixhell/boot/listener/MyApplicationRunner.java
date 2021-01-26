package com.phoenixhell.boot.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-上午 8:36
 */
@Order(1)
@Component
public class MyApplicationRunner  implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunner run-----------------------args:"+args);
    }
}
