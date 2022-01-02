package com.zjgsu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.zjgsu.mapper")
public class Order_includeApplication {
    public static void main(String[] args) {
        SpringApplication.run(Order_includeApplication.class, args);
    }
}
