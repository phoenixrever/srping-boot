package com.phoenixhell.boot.service;

import com.phoenixhell.boot.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author phoenixhell
 * @create 2021/1/15 0015-上午 10:27
 */

/**
 * “@Service注解是标注在实现类上的，因为@Service是把spring容器中的bean进行实例化，
 * 也就是等同于new操作，只有实现类是可以进行new实例化的，而接口则不能，所以是加在实现类上的。”
 */
public interface UserService {
    User getUser(String id);

    List<User> getUsers();

}