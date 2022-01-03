package com.zjgsu.service;

import com.zjgsu.entity.JsonResult;
import com.zjgsu.entity.Order_dish;


public interface OrderService {
    JsonResult addOrder(Order_dish order);
    JsonResult delOrder(int uid);
    JsonResult updateOrder(Order_dish order);
    JsonResult getOrderByid(int uid);
    JsonResult getOrderByuser(int userid);
    JsonResult getAllOrder();
    public JsonResult sureArrive(int uid);
}
