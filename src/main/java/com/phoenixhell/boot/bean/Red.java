package com.phoenixhell.boot.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-下午 3:03
 */

public class Red {
//    @Value("100")
    @Value("#{20-2}")
//    @Value("${配置文件中的环境变量值   }")
    public String name="red1";

    public Red(){
//        System.out.println("red1-------------"+name);
    }
}
