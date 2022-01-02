package com.zjgsu.controller;

import com.zjgsu.entity.Result;
import com.zjgsu.entity.User;
import com.zjgsu.request.UserAddRequest;
import com.zjgsu.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class UserHandler {
    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/sentEmail/{email}")
    public Result<List<User>> sentEmail(@PathVariable("email") String email){
        return userService.sentEmail(email);
    }
    @PostMapping("/reg")
    public Result<List<User>> reg(@RequestBody UserAddRequest userAddRequest){
        String email = userAddRequest.getEmail();
        String pass = userAddRequest.getPass();
        String tmp = userAddRequest.getTmp();
        return userService.reg(email,pass, tmp);
    }
    @PostMapping("/log")
    public Result<List<User>> log(@RequestBody UserAddRequest userAddRequest){
        String email = userAddRequest.getEmail();
        String pass = userAddRequest.getPass();
        return userService.log(email,pass);
    }
}