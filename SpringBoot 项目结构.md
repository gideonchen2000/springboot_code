# SpringBoot 项目结构

## src/main/java包下

- annotation: 放置项目自定义注解
- aspect: 放置切面代码
- config: 放置配置类
- constant: 放置常量, 枚举等定义
  
  - consist: 存放常量
  - enums: 存放枚举

- controller: 放置控制器代码
- filter: 放置一些过滤, 拦截相关代码
- mapper: 放置数据访问层代码接口
- model: 放置数据模型代码
  
  - entity: 放置数据库实体对象定义
  - dto: 存放数据传输对象定义
  - vo: 存放显示层对象定义

- service: 放置具体的业务逻辑代码(接口和实现分离)
  
  - intf: 存放业务逻辑接口定义
  - impl: 存放业务逻辑实际实现

- utils: 放置工具类和辅助代码

## src/main/resources

里面主要存放静态配置文件和页面静态资源等

- mapper: 存放mybatis的xml映射文件(如果用mybatis)
- static: 存放网页静态资源, 比如这个包下可能会有: js, css, img, font...
- template: 存放网页模板, 比如thymeleaf/freemaker模板等
  
  - header
  - sidebar
  - bottom
  - xxx.html 等等

- application.yml 基本配置文件
- application-dev.yml 开发环境配置文件
- application-test.yml 测试环境配置文件
- application-prod.yml 生产环境配置文件

## 关于数据模型定义

- DO(Data Object): 与数据库表结构一一对应, 通过DAO层向上传输数据源对象
- DTO(Data Transfer Object): 数据传输对象, Service或Manager向外传输的对象
- BO(Business Object): 业务对象, 由Service层输出的封装业务逻辑的对象
- AO(Application Object): 应用对象, 在Web层与Service层之间抽象的复用对象模型, 极为贴近展示层, 复用度不高
- VO(View Object)：显示层对象, 通常是Web向 模板渲染引擎层传输的对象
- Query：数据查询对象, 各层接收上层的查询请求. 注意超过2个参数的查询封装, 禁止使用Map类来传输
