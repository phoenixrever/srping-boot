package com.phoenixhell.boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author phoenixhell
 * @create 2021/1/18 0018-下午 2:59
 */
//@Component //或者在conigclass 里面retrun bean
@Aspect
public class LogAspect {
    //public int com...  MathCalculator.*(..)
    //通过在argNames中定义参数名的昵称，从而在value中引用的pointcut方法即可使用昵称
    //不是太理解 没例子
    @Pointcut(value="execution(* com.phoenixhell.boot.aop.MathCalculator.div(..))")
    public void point(){
    }

    //JoinPoint 一定要在参数表的第一位
    @Before(value = "point()")
    public void  logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println("除法"+name+"开始 参数列表是"+ Arrays.asList(args));
    }

    @AfterReturning(value = "point()",returning ="result")
    public void logReturn(Object result){
        System.out.println("返回 结果是"+result);
    }

    @After(value = "point()")
    public void logend(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println("除法"+name+"结束 参数列表是"+ Arrays.asList(args));

    }
    @AfterThrowing(value = "point()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.print("除法"+name+"异常 参数列表是"+ Arrays.asList(args)+" ");
        System.out.println("异常报告"+exception);
    }
}
