package com.phoenixhell.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phoenixhell.boot.bean.Custom;
import org.springframework.stereotype.Service;

/**
 * @author phoenixhell
 * @create 2021/1/15 0015-上午 10:26
 */
/**
 * “@Service注解是标注在实现类上的，因为@Service是把spring容器中的bean进行实例化，
 * 也就是等同于new操作，只有实现类是可以进行new实例化的，而接口则不能，所以是加在实现类上的。”
 */
public interface CustomService extends IService<Custom> {
}
