package com.phoenixhell.test;

import com.phoenixhell.boot.MainApplication;
import com.phoenixhell.boot.aop.MathCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author phoenixhell
 * @create 2021/1/18 0018-下午 3:00
 */
@DisplayName("aspectj测试")
@SpringBootTest(classes = MainApplication.class)
public class AopTest {
    @Autowired
    MathCalculator mathCalculator;

    @Test
    @DisplayName("aspectj")
    public void test1(){
        //自己new的对象 用不到切面
        int div = mathCalculator.div(2, 0   );
        System.out.println(div);
    }
}
