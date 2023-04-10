package com.example.config;

import com.example.web.Myservlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebApplicationConfig {
    // 定义方法, 注册Servlet对象
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        // 第一种方法
        // 第一个参数是 Servlet对象, 第二个是url地址
        // ServletRegistrationBean bean = new ServletRegistrationBean(new Myservlet(), "/myservlet");

        // 第二种方法
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(new Myservlet());
        bean.addUrlMappings("/login", "/test"); // <url-pattern>
        return bean;
    }
}
