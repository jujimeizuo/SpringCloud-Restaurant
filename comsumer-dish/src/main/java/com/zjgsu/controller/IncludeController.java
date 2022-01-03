package com.zjgsu.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zjgsu.entity.Order_include;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order-include")
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
public class IncludeController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    @HystrixCommand
    public Object addOrder(@RequestParam("oid")int oid,@RequestParam("did")String did) {
        Order_include order_include = new Order_include();
        order_include.setOid(oid);
        order_include.setDid(did);
        order_include.setNumber(1);
        Object o = restTemplate.postForObject("http://order-include/add", order_include, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }
    @PostMapping("/update")
    @HystrixCommand
    public Object updateOrder(@RequestParam("oid")int oid,@RequestParam("did")String did,@RequestParam("number")int number) {
        Order_include order_include = new Order_include();
        order_include.setNumber(number);
        order_include.setDid(did);
        order_include.setOid(oid);
        Object o = restTemplate.postForObject("http://order-include/update", order_include, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }

    @GetMapping("/delbyoid/{oid}")
    @HystrixCommand
    public Object delOrder(@PathVariable int oid) {
        Object forObject = restTemplate.getForObject("http://order-include/delbyoid/" + oid, Object.class);
        assert forObject != null;
        log.info(forObject.toString());
        return forObject;
    }

    @GetMapping("/delbyid/{id}")
    @HystrixCommand
    public Object getbyidOrder(@PathVariable int id) {
        Object o = restTemplate.getForObject("http://order-include/getbyid/" + id, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }
    @GetMapping("/getbyid/{oid}")
    @HystrixCommand
    public Object getbycidOrder(@PathVariable int oid) {
        Object o = restTemplate.getForObject("http://order-include/getbyid/" + oid, Object.class);
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
