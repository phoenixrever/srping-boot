package com.phoenixhell.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phoenixhell.boot.MainApplication;
import com.phoenixhell.boot.bean.Custom;
import com.phoenixhell.boot.bean.User;
import com.phoenixhell.boot.mapper.CustomMapper;
import com.phoenixhell.boot.mapper.UserMapper;
import com.phoenixhell.boot.service.CustomService;
import com.phoenixhell.boot.service.Impl.CustomServiceImpl;
import net.minidev.json.JSONArray;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author phoenixhell
 * @create 2021/1/14 0014-上午 9:26
 */
/*
jdbcTemplate是需要注入到Spring容器中的，在你的配置中也看到了，已经注入了，
但是你在测试的时候是在Test修改的方法上测试的，此时项目并没有启动，
JdbcTemplate没有注入到spring容器中，所以你获取到了null
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class TestJDBC {
    //
    @Autowired
    private JdbcTemplate jdbcTemplate;
//    @Autowired
    private DruidDataSource druidDataSource;
//    @Test
//    public void test1(){
//        System.out.println(jdbcTemplate+"---------------");
//        String sql="select * from users";
    //RowMapper  接口 返回不同类型数据,使用这个接口里面的实现类完成数据封装
//        jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<USer>(User.class),id);
    //query 放回list 集合
    //batchupdate 批量操作
//        String sql1="select count(*) from users";
//        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
//        Long aLong = jdbcTemplate.queryForObject(sql1, Long.class);
//        System.out.println(users);
//        System.out.println(aLong);
//        System.out.println (druidDataSource);
    @Autowired
    private CustomServiceImpl customService;
//
//    @Transactional junit5 单元测试完毕自动回滚
    @Test
//    @Transactional
    public void testInsert() {
        System.out.println(("----- InsertTransaction method test ------"));
//        List<Custom> customs = customService.list();
//        Assert.assertEquals(5, customs.size());
//        customs.forEach(System.out::println);
//        String sql="select count(*) from users";
//        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
//        Long aLong = jdbcTemplate.queryForObject(sql, Long.class);
//        System.out.println(users);
//        System.out.println(aLong);
//        boolean custom1 = customService.save(new Custom(null, "cust11111om2222", 24, "1212312@qq.com"));
//        System.out.println(custom1);
//        Custom one = customService.query().eq("name", "Jone").one();
//        List<Custom> ids = customService.list(new QueryWrapper<Custom>().gt("id", 1));
//        System.out.println(one+"-------------");
//        System.out.println(ids+"-------------");
//           boolean custom1 = customService.save(new Custom(null, "cust11111om2222", 24, "1212312@qq.com"));
//        for (int i = 0; i <30 ; i++) {
//           customService.save(new Custom(null, getRandomString(5), (int) (Math.random()*100), getRandomString(10)+"@qq.com"));
//        }
//        Page<Custom> page = customService.page(new Page<Custom>(1, 10), new QueryWrapper<Custom>().orderBy(true,true,"id"));
//        page.getRecords().forEach(System.out::println);


          customService.removeByIds(Arrays.asList(6,7,8,9,10));
//        System.out.println(1/0);
        customService.removeByIds(Arrays.asList(11,12,13,14,15));

    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}

