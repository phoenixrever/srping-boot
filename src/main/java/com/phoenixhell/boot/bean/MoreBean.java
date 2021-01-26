package com.phoenixhell.boot.bean;

import org.springframework.stereotype.Component;

/**
 * @author phoenixhell
 * @create 2021/1/18 0018-下午 1:05
 */
@Component
public class MoreBean {
    public String name="MoreBean1111111";

    @Override
    public String toString() {
        return "MoreBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
