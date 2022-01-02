package com.zjgsu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjgsu.entity.Order_include;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Order_includeMapper extends BaseMapper<Order_include> {

}
