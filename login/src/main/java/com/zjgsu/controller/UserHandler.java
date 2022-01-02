package com.zjgsu.controller;

import com.zjgsu.entity.Result;
import com.zjgsu.entity.User;
import com.zjgsu.request.UserAddRequest;
import com.zjgsu.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserHandler {
    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/reg")
    public Result<List<User>> reg(@RequestBody UserAddRequest userAddRequest){
        String phone = userAddRequest.getPhone();
        String pass = userAddRequest.getPass();
        return userService.reg(phone,pass);
    }
    @PostMapping("/log")
    public Result<List<User>> log(@RequestBody UserAddRequest userAddRequest){
        String phone = userAddRequest.getPhone();
        String pass = userAddRequest.getPass();
        return userService.log(phone,pass);
    }
}
