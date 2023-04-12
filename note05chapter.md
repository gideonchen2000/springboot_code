# 5. 接口架构风格---RESTful

## 5.1 REST

REST(英文: Representational State Transfer, 简称REST)  
是一种互联网软件架构设计风格, 不是标准.  
任何技术都可以实现这种理念, 如果一家架构符合REST原则, 就称它为RESTful架构.  
比如一个http接口: `http://localhost:8080/boot/order?id=1021&status=1`  
采用RESTful风格则为: `http://localhost:8080/boot/order/1021/1`  

## 5.2 RESTful的注解

SpringBoot开发RESTful主要是几个注解实现  
- @PathVariable : 获取url中的数据, 最主要的一个注解  
- @GetMapping : 接收get方式的请求, 等同于@RequestMapping(method=RequestMethod.GET)
- @PostMapping : 接收和处理Post方式的请求, 等同于@RequestMapping(method=RequestMethod.POST)
- @PutMapping : 接收put方式的请求, 可以用PostMapping代替
- @DeleteMapping : 接收delete方式的请求, 可以使用GetMapping代替
- @RestController : 符合注解, 是@Controller和@ResponseBody的组合, 
在类的上面使用@RestController, 表示当前类的所有方法都加入了@ResponseBody

## 5.3 RESTful优点

- 轻量, 直接基于 http, 不再需要任何别的诸如消息协议 
get/post/put/delete为 CRUD 操作
- 面向资源, 一目了然, 具有自解释性
- 数据描述简单, 一般以 xml json 做数据交换
- 无状态, 在调用一个接口(访问 操作资源)的时候, 可以不用考虑上下文, 不用考虑当前状态, 极大的降低了复杂度
- 简单, 低耦合

## Postman : 测试工具

使用Postman : 可以测试 get, post, put, delete 等请求

## 在页面中或者ajax中, 支持put, delete请求

在SpringMVC中有一个过滤器, 支持post请求转为put, delete  
过滤器: org.springframework.web.filter.HiddenHttpMethodFilter  
作用: 把请求中的post请求转为 put, delete  
实现步骤：
1. application.properties(yml) : 开启使用 HiddenHttpMethodFilter 过滤器
2. 在请求页面中, 包含 _method参数, 他的值是 put delete 发起这个请求使用的是post方式
```html
<input type="hidden" name="_method" value="put">
```