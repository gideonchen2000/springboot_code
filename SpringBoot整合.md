# SpringBoot整合

## SpringBoot整合Spring Data JPA

JPA是SUN公司提出的一套Java持久化规范. 也就是只定义标准, 不提供实现

JPA是为了整合市面上已有的ORM框架.

Spring Data JPA只是一个抽象层, 它上接JPA下接ORM框架, 通过基于JPA的Respository接口极大地减少了JPA作为数据访问方案的代码量, 简化了持久层开发并且屏蔽了各大ORM框架的差异

- JPA是规范, 统一了规范才便于使用
- Hibernate是JPA的实现, 是一套成熟的ORM框架
- Spring Data JPA是Spring提出的, 它增加了一个抽象层, 用来屏蔽不同ORM框架之间的差异

## SpringBoot整合Thymeleaf

1. 常用表达式

   - `${...}`变量表达式
   - `*{...}`选择表达式
   - `#{...}`文字表达式
   - `@{...}`URL表达式
   - `#maps`对象表达式

2. 常用标签

   - th:action 定义服务器端控制器路径
   - th:each 循环语句
   - th:field 表单字段
   - th:href URL连接
   - th:id div标签中的id
   - th:if 条件判断
   - th:include 引入文件
   - th:fragment 定义代码片段
   - th:object 替换对象
   - th:src 图片地址
   - th:text 文本
   - th:value 属性值

3. 常用函数

    - #dates 日期函数
    - #lists 列表函数
    - #arrays 数组函数
    - #strings 字符串函数
    - #numbers 数字函数
    - #calendars 日历函数
    - #objects 对象函数
    - #bools 布尔函数

### 整合Thymeleaf

第一步, 在pom.xml文件中添加Thymeleaf的依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

第二步, 在application.yml文件中添加Thymeleaf的配置

```yml
spring:
  thymeleaf:
    cache: false # 开发时关闭缓存，不然看不到实时页面
```

Thymeleaf模板引擎默认会读取resource目录下的templates目录, 这个目录是用来存放HTML页面的

第三步, 新建UserController.java控制器

```java
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("users", userService.findAll());
        return "all";
    }
}
```

- @Controller 注解表示该类为一个控制器类
- @RequestMapping 注解用来处理请求地址映射, 可用于类或者方法
- Model 接口可以承载数据库里查到的数据, 前端可以从 model 中取出来

第四步, 在resource/templates目录下新建all.html文件(文件名对应控制器中all方法返回的字符串)

```html
<!DOCTYPE html>
<html lang="zh" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>Thymeleaf</title>
</head>
<body>
    <table>
        <tr>
            <td>用户名</td>
            <td>密码</td>
        </tr>
        <tr th:each="user:${users}">
            <td th:text="${user.name}"></td>
            <td th:text="${user.password}"></td>
        </tr>
    </table>
</body>
</html>
```

启动主类, 在浏览器中访问接口即可
