package com.phoenixhell.boot.aop;

import org.springframework.stereotype.Component;

/**
 * @author phoenixhell
 * @create 2021/1/18 0018-下午 2:57
 */
@Component
public class MathCalculator {
    public int div(int i, int j){
        return i/j;
    }
}
