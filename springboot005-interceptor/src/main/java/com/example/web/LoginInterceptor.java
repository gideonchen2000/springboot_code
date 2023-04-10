package com.example.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 自定义拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return boolean
     *      true: 请求能被Controller处理
     *      false: 请求被截断
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了 LoginInterceptor的重写preHandle方法");
        return true;
    }
}
