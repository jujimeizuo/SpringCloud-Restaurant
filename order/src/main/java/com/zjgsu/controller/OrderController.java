package com.zjgsu.controller;

import com.zjgsu.entity.JsonResult;
import com.zjgsu.entity.Order_dish;
import com.zjgsu.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public JsonResult addOrder(@RequestBody Order_dish order_dish){
        Order_dish order = new Order_dish();
        order.setCid(order_dish.getCid());
        order.setState(0);
        //order.setUid(1);
        JsonResult jsonResult = orderService.addOrder(order);
        return jsonResult;
    }

    @RequestMapping("/update")
    public JsonResult updateOrder(@RequestBody Order_dish order_dish){
        Order_dish order = new Order_dish();
        order.setCid(order_dish.getId());
        order.setState(0);
        //order.setUid(1);
        JsonResult jsonResult = orderService.updateOrder(order);
        return jsonResult;
    }

    @RequestMapping("/del/{uid}")
    public JsonResult delOrder(@PathVariable int uid){
        JsonResult jsonResult = orderService.delOrder(uid);
        return jsonResult;
    }

    @RequestMapping("/getbyid/{uid}")
    public JsonResult getbyidOrder(@PathVariable int uid){
        JsonResult jsonResult = orderService.getOrderByid(uid);
        return jsonResult;
    }

    @RequestMapping("/getbycid/{cid}")
    public JsonResult getbycidOrder(@PathVariable int cid){
        JsonResult jsonResult = orderService.getOrderByuser(cid);
        return jsonResult;
    }
    @RequestMapping("/getall")
    public JsonResult getallOrder(){
        JsonResult jsonResult = orderService.getAllOrder();
        return jsonResult;
    }
}
