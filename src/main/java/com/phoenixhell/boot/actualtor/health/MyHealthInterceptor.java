package com.phoenixhell.boot.actualtor.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author phoenixhell
 * @create 2021/1/16 0016-上午 8:44
 */
//indicator  指示器; 标志; 指针; 指示信号; 迹象; 转向灯; 方向灯;
@Component
public class MyHealthInterceptor extends AbstractHealthIndicator {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        if(jdbcTemplate==null){
            builder.down();
            map.put("message","up");
        }else {
            builder.up();
//            builder.status(Status.UNKNOWN)
            map.put("message","down");
        }
        builder.withDetail("code",444).withDetails(map);
    }
}
