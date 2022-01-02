package com.zjgsu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.entity.JsonResult;
import com.zjgsu.entity.Order_include;
import com.zjgsu.entity.ResultCode;
import com.zjgsu.mapper.Order_includeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncludeServiceImpl implements IncludeService{
    @Autowired
    Order_includeMapper order_includeMapper;

    @Override
    public JsonResult addInclude(Order_include order_include) {
        QueryWrapper<Order_include> wrapper = new QueryWrapper<>();
        wrapper.eq("oid",order_include.getOid());
        wrapper.eq("did",order_include.getDid());
        Order_include order_include1 = order_includeMapper.selectOne(wrapper);
        if(order_include1!=null){
            return new JsonResult(400,"not reapt submit",null);
        }
        order_includeMapper.insert(order_include);
        return new JsonResult(ResultCode.SUCCESS);
    }

    @Override
    public JsonResult delIncludeByoid(int oid) {
        QueryWrapper<Order_include> wrapper = new QueryWrapper<>();
        wrapper.eq("oid",oid);
        order_includeMapper.delete(wrapper);
        return new JsonResult(ResultCode.SUCCESS);
    }
    @Override
    public JsonResult delIncludeByid(int uid) {
        QueryWrapper<Order_include> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",uid);
        order_includeMapper.delete(wrapper);
        return new JsonResult(ResultCode.SUCCESS);
    }

    @Override
    public JsonResult getByid(int oid) {
        QueryWrapper<Order_include> wrapper = new QueryWrapper<>();
        wrapper.eq("oid",oid);
        List list = order_includeMapper.selectList(wrapper);
        return new JsonResult(ResultCode.SUCCESS,list);
    }

    @Override
    public JsonResult updateInclude(Order_include include) {
        QueryWrapper<Order_include> wrapper = new QueryWrapper<>();
        wrapper.eq("oid",include.getOid());
        wrapper.eq("did",include.getDid());
        Order_include order_include1 = order_includeMapper.selectOne(wrapper);
        if(order_include1 ==null){
            return new JsonResult(400,"no such order",null);
        }
        order_includeMapper.update(include,wrapper);
        return new JsonResult(ResultCode.SUCCESS);
    }


}
