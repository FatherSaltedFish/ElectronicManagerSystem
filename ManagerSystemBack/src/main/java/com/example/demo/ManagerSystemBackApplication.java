package com.example.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//事务管理器
@MapperScan("com.example.demo.repository")

public class ManagerSystemBackApplication {

    public static void main(String[] args) {

        SpringApplication.run(ManagerSystemBackApplication.class, args);
    }

}
