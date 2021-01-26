package com.phoenixhell.boot.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author phoenixhell
 * @create 2021/1/15 0015-下午 2:29
 */

/**
 *
 */
//@Component
//public class RedisUrlCountInterceptor implements HandlerInterceptor {
//    @Autowired
//    StringRedisTemplate redisTemplate;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String requestURI = request.getRequestURI();
//        redisTemplate.opsForValue().increment(requestURI);
//        return true;
//    }
//}
