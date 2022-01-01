package com.zjgsu.restaurant.user1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/detail")
    public String detail() {
        System.out.println("port:" + port);
        return "服务提供者，端口为：" + port;
    }
}