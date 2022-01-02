package com.zjgsu.controller;

import com.zjgsu.entity.Dish;
import com.zjgsu.entity.DishVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/dish")
@Slf4j
public class DishController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/insertDish")
    public Object insertDish(@RequestBody DishVo dishVo) {
        Object o = restTemplate.postForObject("http://dish/insertDish", dishVo, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }

    @GetMapping("/deleteDish/{did}")
    public Object deleteDish(@PathVariable String did) {
        Object forObject = restTemplate.getForObject("http://dish/deleteDish/" + did, Object.class);
        assert forObject != null;
        log.info(forObject.toString());
        return forObject;
    }

    @PostMapping("/updateDish")
    public Object updateDish(@RequestBody Dish dish) {
        Object o = restTemplate.postForObject("http://dish/updateDish", dish, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }

    @PostMapping("/queryAllDish")
    public Object queryAllDish() {
        Object o = restTemplate.postForObject("http://dish/queryAllDish", null, Object.class);
        assert o != null;
        log.info(o.toString());
        return o;
    }
}
