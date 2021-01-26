package com.phoenixhell.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author phoenixhell
 * @create 2021/1/9 0009-上午 10:51
 * @component + @ConfigurationProperties 导入属性加注册容器  等同于在config里面
 * @EnableConfigurationProperties(User.class)  他有2个作用 开启user属性绑定 注册容器
 * user 是第三方包时候 没有@component
 *
 *
 *
 */
//@Profile("prod")  生产环境生效
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "user") //自带的配置
public class User {
    private Integer id;
    private String username;
    private String password;
    private Dept dept;

}
