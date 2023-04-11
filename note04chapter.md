# 4. ORM操作数据库

MyBatis是ORM中的一种, 使用MyBatis框架操作数据, 在SpringBoot框架集成MyBatis  
使用步骤: 
1. mybatis起步依赖: 完成mybatis对象自动配置, 对象放在容器中
2. pom.xml 指定把src/main/java目录中的xml文件包含到classpath中
3. 创建实体类Student
4. 创建Dao接口 StudentDao, 创建一个查询学生的方法
5. 创建Dao接口对应的Mapper文件, xml文件, 写sql语句
6. 创建Service层对象, 创建StudentService接口和他的实现类. 去Dao对象的方法, 完成数据库的操作
7. 创建Controller对象, 访问Service
8. 写application.properties文件 配置数据库的连接信息

## 第一种方法: @Mapper

@Mapper: 放在dao接口的上面, 每个接口都需要使用这个注解.
```java
/**
 * @Mapper：告诉MyBatis这是dao接口，创建此接口的代理对象。
 *     位置：在类的上面
 */
@Mapper
public interface StudentDao {

    Student selectById(@Param("stuId") Integer id);
}
```

## 第二种方法: @MapperScan

```java
/**
 * @MapperScan: 找到Dao接口和Mapper文件
 *     basePackages：Dao接口所在的包名, 是一个String[]字符串数组, 所以可以传多个包名
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.example.dao","com.example.mapper"})
public class Application {
}
```

## 第三种方法: Mapper文件和Dao接口分开管理

把Mapper文件放在resources目录下  
1. 在resources目录中创建子目录(自定义的), 例如mapper
2. 把 mapper 文件放到 mapper 目录中
3. 在application.properties文件中, 指定mapper文件的目录
4. 在pom.xml中指定 把resources目录中的文件, 编译到目标目录中

```properties
#指定mapper文件的位置
mybatis.mapper-locations=classpath:mapper/*.xml
#指定mybatis的日志
mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```

```xml
<!--resources插件-->
<resources>
   <resource>
      <directory>src/main/resources</directory>
      <includes>
         <include>**/*.*</include>
      </includes>
   </resource>
</resources>
```

## 事务

Spring框架中的事务: 

1. 管理事务的对象: 事务管理器(接口, 接口有很多的实现类)  
例如: 使用Jdbc或mybatis访问数据库, 使用的事务管理器: DataSourceTransactionManager

2. 声明式事务: 在xml配置文件或者使用注解说明事务控制的内容  
控制事务有: 隔离级别, 传播行为, 超时时间

3. 事务处理方式:
   1. Spring框架中的@Transactional 
   2. aspectj框架可以在xml配置文件中, 声明事务控制的内容

SpringBoot中使用事务: 上面的两种方式都可以

1. 在业务方法的上面加入@Transactional, 加入注解后, 方法就有事务功能了
2. 明确的在 主启动类 的上面加入 @EnableTransactionManager
