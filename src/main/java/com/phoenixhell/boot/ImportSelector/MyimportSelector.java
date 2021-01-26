package com.phoenixhell.boot.ImportSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-下午 2:33
 */

public class MyimportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.phoenixhell.boot.bean.Blue","com.phoenixhell.boot.bean.Yellow"};
    }

}
