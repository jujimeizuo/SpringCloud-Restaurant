package com.zjgsu.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zjgsu.entity.UserAddRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/reg")
    @HystrixCommand
    public Object reg(@RequestBody UserAddRequest userAddRequest) {
        Object o = restTemplate.postForObject("http://login/reg", userAddRequest, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }

    @PostMapping("log")
    @HystrixCommand
    public Object log(@RequestBody UserAddRequest userAddRequest) {
        Object o = restTemplate.postForObject("http://login/log", userAddRequest, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }

    /**
     *  服务响应超时的回调
     * @return 错误码
     * */
    @RequestMapping(value = "/defaultFallback")
    public Object defaultFallback () {
        Map<String , Object> result = new HashMap<>();
        result.put("code" , 0);
        result.put("msg" , "服务器繁忙");
        result.put("state" , false);
        return result;
    }

}
