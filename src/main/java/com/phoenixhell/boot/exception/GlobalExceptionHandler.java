package com.phoenixhell.boot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author phoenixhell
 * @create 2021/1/13 0013-下午 2:10
 */
@Slf4j
//@ControllerAdvice //注册
public class GlobalExceptionHandler  {
    //异常处理器
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handleArithException(Exception e){
        log.error("-----------------------"+e);
        return "index"; //视图地址或者modelanview
    }
}
