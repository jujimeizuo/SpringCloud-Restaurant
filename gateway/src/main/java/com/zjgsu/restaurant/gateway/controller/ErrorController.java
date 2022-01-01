package com.zjgsu.restaurant.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ErrorController {

    /**
     *  服务响应超时的回调
     * @return 错误码
     * */
    @RequestMapping(value = "/fallback")
    public Object fallback () {
        Map<String , Object> result = new HashMap<>();
        result.put("code" , 0);
        result.put("msg" , "服务器繁忙");
        result.put("state" , false);
        return result;
    }

}
