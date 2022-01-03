package com.zjgsu.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zjgsu.entity.Order_dish;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    @HystrixCommand
    public Object addOrder(@RequestParam("userid")int uid) {
        Order_dish order_dish = new Order_dish();
        order_dish.setCid(uid);
        Object o = restTemplate.postForObject("http://order/add", order_dish, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }
    @PostMapping("/update")
    @HystrixCommand
    public Object updateOrder(@RequestParam("userid")int uid) {
        Order_dish order_dish = new Order_dish();
        order_dish.setCid(uid);
        Object o = restTemplate.postForObject("http://order/update", order_dish, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }
    @HystrixCommand
    @GetMapping("/del/{uid}")
    public Object delOrder(@PathVariable int uid) {
        Object forObject = restTemplate.getForObject("http://order/del/" + uid, Object.class);
        assert forObject != null;
        log.info(forObject.toString());
        return forObject;
    }
    @HystrixCommand
    @GetMapping("/getbyid/{uid}")
    public Object getbyidOrder(@PathVariable int uid) {
        Object o = restTemplate.getForObject("http://order/getbyid/"+ uid, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }
    @HystrixCommand
    @GetMapping("/getbycid/{cid}")
    public Object getbycidOrder(@PathVariable int cid) {
        Object o = restTemplate.getForObject("http://order/getbycid/"+ cid, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }

    @HystrixCommand
    @GetMapping("/surearrive/{uid}")
    public Object sureOrder(@PathVariable int uid) {
        Object o = restTemplate.getForObject("http://order/surearrive/"+ uid, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }

    @HystrixCommand
    @GetMapping("/getall")
    public Object queryAllDish() {
        Object o = restTemplate.getForObject("http://order/getall", Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }
    @RequestMapping(value = "/defaultFallback")
    public Object defaultFallback () {
        Map<String , Object> result = new HashMap<>();
        result.put("code" , 0);
        result.put("msg" , "服务器繁忙");
        result.put("state" , false);
        return result;
    }
}
