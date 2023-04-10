# 2. SpringBoot

## 2.1 介绍
SpringBoot是Spring中的一个成员, 可以简化Spring，SpringMVC的使用  
他的核心还是IOC容器  

特点:  
- 创建spring应用
- 内嵌tomcat, jetty, Undertow
- 提供了 starter---起步依赖, 简化应用配置
- 尽可能地自动配置(就是把spring中的, 第三方库中的对象都创建好, 放到容器中, 开发人员可以直接使用)spring和第三方库. 
- 提供了健康检查, 统计信息, 外部化配置
- 不用生成代码, 不用使用xml做配置

## 2.2 创建SpringBoot项目

### 2.2.1 第一种方式 使用spring提供的初始化器

使用的地址： <https://start.spring.io>

### 2.2.2 国内的人可以使用国内镜像

## 2.3 注解的使用

1. @SpringBootConfiguration: 使用了@SpringBootConfiguration注解标注的类, 可以作为配置文件使用的, 
   可以使用@Bean声明对象, 注入到容器
2. @EnableAutoConfiguration: 启用自动配置, 把java对象配置好, 注入到spring容器中. 例如可以把mybatis的对象创建好, 放入到容器中
3. @ComponentScan: @ComponentScan扫描器, 找到注解, 根据注解的功能创建对象, 给属性赋值等等
   默认扫描的包: @ComponentScan所在的类所在的包和子包

## 2.4 SpringBoot的配置文件

配置文件名称: application  
扩展名有: properties(k=v) ; yml(k: v)  
也就是说可以使用: application.properties, application.yml  

例1: application.properties设置端口和上下文
```properties
#设置端口号
server.port=8082
#设置访问应用上下文路径  context-path
server.servlet.context-path=/my
```

例2: application.yml设置端口和上下文
```yml
server:
  port: 8083
  servlet:
    context-path: /my2
```
注意: 当两种格式配置文件同时存在, 在SpringBoot2.4开始, 使用的是yml配置文件.  
修改配置名称都为 application. 

## 2.5 多环境配置

有开发环境, 测试环境, 上线的环境  
每个环境有不同的配置信息, 例如 端口, 上下文件, 数据库url, 用户名, 密码等等...  
使用多环境配置文件, 可以方便的切换不同的配置  
使用方法: 创建多个配置文件, 名称规则： application-环境名称.properties(yml)  
开发环境的配置文件: application-dev.properties(application-dev.yml)  
测试使用的配置： application-test.yml

## 2.6 SpringBoot 自定义配置

- @Value注解: @Value("${key}"), key来自application.properties(yml)
- @ConfigurationProperties注解: 将整个文件映射成一个对象, 用于自定义配置项比较多的情况(属性: prefix 配置文件中的自定义key的前缀)

## 2.7 SpringBoot 中使用JSP

SpringBoot不推荐使用JSP, 而是使用模板技术代替JSP(现在更多使用前后端分离)

## 2.8 使用容器

通过代码, 从容器中获取对象  
通过SpringApplication.run(Application.class, args); 的返回值获取容器

## 2.9 CommandLineRunner接口, ApplicationRunner接口

开发中可能会有这样的情景. 需要在容器启动后执行一些内容. 比如读取配置文件, 数
据库连接之类的. SpringBoot 给我们提供了两个接口来帮助我们实现这种需求. 这两个接口
分别为 CommandLineRunner 和 ApplicationRunner.  
他们的执行时机为容器启动完成的时候. 
这两个接口中都有一个 run 方法, 我们只需要实现这个方法即可. 这两个接口的不同之处
在于: ApplicationRunner 中 run 方法的参数为 ApplicationArguments, 而 CommandLineRunner
接口中 run 方法的参数为 String 数组  
