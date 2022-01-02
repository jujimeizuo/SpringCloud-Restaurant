package com.zjgsu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjgsu.entity.Order_dish;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Order_DishMapper extends BaseMapper<Order_dish> {
}
