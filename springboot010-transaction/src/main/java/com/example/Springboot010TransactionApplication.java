package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @EnableTransactionManagement: 开启事务支持
 * EnableTransactionManagement可选, 但是@Service必须添加事务才生效
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.example.dao")
public class Springboot010TransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot010TransactionApplication.class, args);
    }

}
