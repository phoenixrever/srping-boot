package com.phoenixhell.boot.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;

/**
 * @author phoenixhell
 * @create 2021/1/13 0013-下午 3:04
 */
//@Order(value = Ordered.HIGHEST_PRECEDENCE)//优先级 数字越小越高
//一旦定义 GlobalExceptionHandler @ResponseStatus 定义的异常 都失效(被自定义覆盖)
//@Component
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        try {
            httpServletResponse.sendError(511,"ssssxxxxxxxxxxxxxxxs");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return new ModelAndView();
    }
}
