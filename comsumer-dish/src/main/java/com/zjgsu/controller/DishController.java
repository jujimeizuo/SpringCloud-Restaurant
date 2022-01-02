package com.zjgsu.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zjgsu.entity.Dish;
import com.zjgsu.entity.DishVo;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.TIMEOUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping(value = "/dish")
@DefaultProperties(defaultFallback = "defaultFallback")
public class DishController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/insertDish")
    @HystrixCommand
    public Object insertDish(@RequestBody DishVo dishVo) {
        Object o = restTemplate.postForObject("http://dish/insertDish", dishVo, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }

    @GetMapping("/deleteDish/{did}")
    @HystrixCommand
    public Object deleteDish(@PathVariable String did) {
        Object forObject = restTemplate.getForObject("http://dish/deleteDish/" + did, Object.class);
        assert forObject != null;
        log.info(forObject.toString());
        return forObject;
    }

    @PostMapping("/updateDish")
    @HystrixCommand
    public Object updateDish(@RequestBody Dish dish) {
        Object o = restTemplate.postForObject("http://dish/updateDish", dish, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }

    @PostMapping("/queryAllDish")
    @HystrixCommand
    public Object queryAllDish() {
        Object o = restTemplate.postForObject("http://dish/queryAllDish", null, Object.class);
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
