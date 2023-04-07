# 1. Java Config

## 1.1 JavaConfig

JavaConfig: 使用java类作为xml配置文件的替代, 是配置**spring容器**的纯java的方式. 
在这个java类这可以创建java对象, 把对象放入spring容器中（注入到容器）  

使用两个注解:

1) @Configuration : 放在一个类的上面, 表示这个类是作为配置文件使用的

2) @Bean : 声明对象, 把对象注入到容器中

## 1.2 @ImportResource

@ImportResource是导入xml配置, 等同于xml文件的resources  
如有一些bean的配置放在了配置文件之中, 又想使用JavaConfig配置容器, 利用@ImpotResource利用已经存在的xml配置文件  

## 1.3 @PropertyResource

@PropertyResource: 读取properties属性配置文件, 使用属性配置文件可以实现外部化配置  
在程序代码之外提供数据  

步骤: 
1. 在resources目录下, 创建properties文件, 使用k=v的格式提供数据
2. 在PropertyResource 指定properties文件的位置
3. 使用@Value(value="${key}")

