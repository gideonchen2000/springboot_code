package com.example.config;

import com.example.web.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class WebSystemConfig {

    // 注册Servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean reg = new ServletRegistrationBean(new MyServlet(), "/myservlet");
        return reg;
    }

    //注册Filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {

        FilterRegistrationBean reg = new FilterRegistrationBean();

        //使用框架中的过滤器类
        CharacterEncodingFilter filter = new CharacterEncodingFilter();

        //指定request, response使用的编码方式
        filter.setEncoding("utf-8");

        //指定request, response使用encoding的值
        filter.setForceEncoding(true);

        reg.setFilter(filter);

        //指定 过滤的url地址
        reg.addUrlPatterns("/*");
        return reg;
    }
}
