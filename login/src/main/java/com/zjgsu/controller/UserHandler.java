package com.zjgsu.controller;

import com.zjgsu.entity.Result;
import com.zjgsu.entity.User;
import com.zjgsu.request.UserAddRequest;
import com.zjgsu.server.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@Slf4j
public class UserHandler {
    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/sentEmail/{email}")
    public Result<List<User>> sentEmail(@PathVariable String email){
        Result<List<User>> result = userService.sentEmail(email);
        log.info("port: " + port + "----------发送邮件: " + email);
        return result;
    }
    @PostMapping("/reg")
    public Result<List<User>> reg(@RequestBody UserAddRequest userAddRequest){
        String email = userAddRequest.getEmail();
        String pass = userAddRequest.getPass();
        String tmp = userAddRequest.getTmp();
        Result<List<User>> result = userService.reg(email, pass, tmp);
        log.info("port: " + port + "----------注册: " + result.toString());
        return result;
    }
    @PostMapping("/log")
    public Result<List<User>> log(@RequestBody UserAddRequest userAddRequest){
        String email = userAddRequest.getEmail();
        String pass = userAddRequest.getPass();
        Result<List<User>> result = userService.log(email, pass);
        log.info("port: " + port + "----------登录: " + result.toString());
        return result;
    }
}