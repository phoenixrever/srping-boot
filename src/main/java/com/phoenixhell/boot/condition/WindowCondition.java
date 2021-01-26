package com.phoenixhell.boot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-上午 11:20
 */

public class WindowCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        String property = context.getEnvironment().getProperty("os.name");
       if(property!=null){
           return property.contains("Windows");
       }else{
           return false;
       }


    }
}
