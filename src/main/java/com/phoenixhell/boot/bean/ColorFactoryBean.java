package com.phoenixhell.boot.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author phoenixhell
 * @create 2021/1/17 0017-下午 3:46
 */

public class ColorFactoryBean implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
