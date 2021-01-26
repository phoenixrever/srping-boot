package com.phoenixhell.boot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author phoenixhell
 * @create 2021/1/18 0018-下午 2:13
 */
@Component
public class Boss {
//    @Autowired 后面版本会建议 final 带参数构造方式 防止在构造器中取值
    private Car car;

//    @Autowired  //只有一个有参数 可以省略
    public Boss(Car car){
        this.car=car;
    }
    public Car getCar() {
        return car;
    }

//    @Autowired
    // spring 容器调用创建当前对象就会调用方法进行赋值 自动获取容器中的car
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
