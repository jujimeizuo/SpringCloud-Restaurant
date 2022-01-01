package com.zjgsu.restaurant.user1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class User1Application {
    public static void main(String[] args) {
        SpringApplication.run(User1Application.class, args);
    }
}
