# 3. Web组件

## 3.1 拦截器

SpringMVC使用拦截器  
1. 自定义拦截器类, 实现HandlerInterceptor接口
2. 注册拦截器类

SpringBoot使用拦截器步骤  
1. 创建类实现HandlerInterceptor接口
2. 注册拦截器对象
3. 创建使用的Controller
4. 主启动类 启动
5. 分别访问 user/account, user/login 观察控制台的拦截的输出语句

## 3.2 SpringBoot中使用Servlet

ServletRegistrationBean 用来做在servlet 3.0+容器中注册servlet的功能, 但更具有SpringBean友好性  

实现步骤:
1. 创建Servlet类(MyServlet.java), 创建类继承HttpServlet
2. 注册Servlet(WebApplicationConfig.java), 让框架能找到Servlet
3. 主启动类 启动 在浏览器中访问loginServlet

## 3.3 SpringBoot中使用Filter

Filter是Servlet规范中的过滤器, 可以处理请求, 对请求的参数, 属性进行调整. 常常在过滤器中处理字符编码
FilterRegistrationBean 用来注册Filter对象  
实现步骤:
1. 创建自定义过滤器类
2. 注册Filter过滤器对象
3. 创建Controller
4. 启动应用, 在浏览器访问 user/account, /query 查看浏览器和控制台运行结果

## 3.4 字符集过滤器的应用

CharacterEncodingFilter: 解决post请求中乱码的问题  
在SpringMVC框架, 在web.xml注册过滤器. 配置他的属性  

第一种方法:  
1. 配置字符集过滤器
2. 在application.properties, 禁用Spring Boot中默认启用的过滤器"server.servlet.encoding.enabled=false"

第二种方式:  
Spring Boot项目默认启用了CharacterEncodingFilter, 设置他的属性就可以  
在 application.properties 文件中  
```properties
# 让系统的CharacterEncodingFilter生效 
server.servlet.encoding.enabled=true
#指定使用的编码方式
server.servlet.encoding.charset=utf-8
#强制request， response 使用charset属性的值utf-8 
server.servlet.encoding.force=true
```
