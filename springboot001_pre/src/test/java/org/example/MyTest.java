package org.example;

import org.example.vo.Cat;
import org.example.vo.Student;
import org.example.vo.Tiger;
import org.example.vo.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    /* 使用xml作为容器配置文件 */
    @Test
    public void test01() {
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("myStudent");
        System.out.println("容器中的对象: "+student);
    }

    /**
     * 使用JavaConfig
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = (Student) ctx.getBean("createStudent");
        System.out.println("使用JavaConfig创建的bean对象: "+student);
    }

    @Test
    public void test3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = (Student) ctx.getBean("rose");
        System.out.println("使用JavaConfig创建的bean对象: "+student);
    }

    @Test
    public void test4() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Cat cat = (Cat)ctx.getBean("myCat");
        System.out.println("cat == "+cat);
    }

    @Test
    public void test5() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Tiger tiger = (Tiger)ctx.getBean("tiger");
        System.out.println("tiger == "+tiger);
    }
}
