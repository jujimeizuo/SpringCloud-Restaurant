package com.zjgsu.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
public class LoginController {




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
