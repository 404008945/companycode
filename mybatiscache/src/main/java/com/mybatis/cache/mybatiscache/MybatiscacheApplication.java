package com.mybatis.cache.mybatiscache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan("com.mybatis.cache.mybatiscache.entity") //扫描的mapper
@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
public class MybatiscacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatiscacheApplication.class, args);
    }
}
