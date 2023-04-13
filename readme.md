# 前置知识总结

## Spring容器

spring容器可以理解为生产对象（OBJECT）的地方, 它负责了对象的整个生命周期--创建、装配、销毁.  
这里对象的创建管理的控制权都交给了Spring容器, 所以这是一种控制权的反转, 称为IOC容器, 而这里IOC容器不只是Spring才有, 很多框架也都有该技术.  

## 项目架构

- 数据持久层(DAO) : 目的是在java对象与数据库之间建立映射, 也就是说它的作用是将某一个java类对应到数据库中的一张表.

  - repository : 是存放一些数据访问类 (也就是一些能操纵数据库的类) 的包
  - domain : 是存放实体类的包

- 业务逻辑层(service) : 处理业务逻辑.
  
  - service : 存放业务逻辑接口的包
  - serviceImpl : 存放业务逻辑实现类的包, 其中的类实现service中的接口

- 视图层(view) : 展现数据
- 控制层(controller) : 接收视图层的请求并调用业务逻辑层的方法.

- utils包 : 存放工具类, 一些自己封装的工具
- config包 : 存放配置类, 一些配置如登录拦截器, 安全配置等
