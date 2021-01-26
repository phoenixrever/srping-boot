package com.phoenixhell.boot.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-上午 8:38
 */
@Order(2) //数字大优先级高
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner ---------run->>>>>>>>>");
    }
}
