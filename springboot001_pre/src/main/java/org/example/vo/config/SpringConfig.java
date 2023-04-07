package org.example.vo.config;

import org.example.vo.Student;
import org.springframework.context.annotation.*;

/**
 * Configuration: 表示当前类是作为配置文件使用的, 就是用来配置容器的
 *
 *      SpringConfig这个类现在就相当于beans.xml
 */
@Configuration
@ImportResource(value = "classpath:applicationContext.xml")
@PropertySource(value = "classpath:config.properties")
@ComponentScan(basePackages = "org.example.vo")
public class SpringConfig {
    /**
     * 创建方法, 方法的返回值是对象, 在方法的上面写上 @Bean
     * 方法的返回值对象就注入到容器中
     *
     * Bean: 把对象注入到spring容器中, 作用相当于<bean>
     *
     */
    @Bean
    public Student createStudent() {
        Student s1 = new Student();
        s1.setName("jack");
        s1.setAge(22);
        s1.setSex("boy");
        return s1;
    }

    @Bean(name = "rose")
    public Student makeStudent() {
        Student s2 = new Student();
        s2.setName("rose");
        s2.setAge(23);
        s2.setSex("boy");
        return s2;
    }
}
