package com.phoenixhell.boot.service;

import com.phoenixhell.boot.bean.MoreBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author phoenixhell
 * @create 2021/1/18 0018-下午 1:46
 */
@Repository
public class MoreBeanService {

//    @Qualifier("moreBean2")  //getbean(moreBean) 的也变成moreBean2
    @Autowired(required = false)
    MoreBean moreBean;
}
