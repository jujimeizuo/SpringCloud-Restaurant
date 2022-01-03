package com.zjgsu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.entity.JsonResult;
import com.zjgsu.entity.Order_dish;
import com.zjgsu.entity.ResultCode;
import com.zjgsu.mapper.Order_DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class OrderServiceImpl implements com.zjgsu.service.OrderService {
    @Autowired
    Order_DishMapper orderMapper;

    @Override
    public JsonResult addOrder(Order_dish order) {
        //QueryWrapper<Order_dish> wrapper = new QueryWrapper<>();
        Date date = new Date();
        order.setSubmitTime(date);
        orderMapper.insert(order);
        return new JsonResult(ResultCode.SUCCESS);
    }

    @Override
    public JsonResult delOrder(int uid) {
        QueryWrapper<Order_dish> wrapper = new QueryWrapper<>();
        wrapper.eq("id",uid);
        Order_dish order_dish = orderMapper.selectOne(wrapper);
        if(order_dish==null){
            return new JsonResult(ResultCode.FAILD,"no such order");
        }
        orderMapper.delete(wrapper);
        return new JsonResult(ResultCode.SUCCESS);
    }

    @Override
    public JsonResult updateOrder(Order_dish order) {
        QueryWrapper<Order_dish> wrapper = new QueryWrapper<>();
        wrapper.eq("id",order.getId());
        Order_dish order_dish = orderMapper.selectOne(wrapper);
        order.setSubmitTime(order_dish.getSubmitTime());
        return new JsonResult(ResultCode.SUCCESS);
    }

    @Override
    public JsonResult getOrderByid(int uid) {
        QueryWrapper<Order_dish> wrapper = new QueryWrapper<>();
        wrapper.eq("id",uid);
        Order_dish order_dish = orderMapper.selectOne(wrapper);
        return new JsonResult(ResultCode.SUCCESS,order_dish);
    }

    @Override
    public JsonResult getOrderByuser(int userid) {
        QueryWrapper<Order_dish> wrapper = new QueryWrapper<>();
        wrapper.eq("cid",userid);
        List<Order_dish> order_dishArrayList = orderMapper.selectList(wrapper);
        return new JsonResult(ResultCode.SUCCESS,order_dishArrayList);
    }
    @Override
    public JsonResult getAllOrder() {
        QueryWrapper<Order_dish> wrapper = new QueryWrapper<>();
        List<Order_dish> order_dishArrayList = orderMapper.selectList(wrapper);
        return new JsonResult(ResultCode.SUCCESS,order_dishArrayList);
    }
    @Override
    public JsonResult sureArrive(int uid) {
        QueryWrapper<Order_dish> wrapper = new QueryWrapper<>();
        wrapper.eq("id",uid);
        Order_dish order_dish = orderMapper.selectOne(wrapper);
        order_dish.setState(1);
        orderMapper.update(order_dish,wrapper);
        return new JsonResult(ResultCode.SUCCESS);
    }
}
