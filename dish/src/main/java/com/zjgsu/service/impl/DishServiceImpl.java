package com.zjgsu.service.impl;

import com.zjgsu.mapper.DishMapper;
import com.zjgsu.pojo.Dish;
import com.zjgsu.service.DishService;
import com.zjgsu.service.vo.DishVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;

    public String insertDish(DishVo dishVo) {
        Dish dish = new Dish();
        dish.setDid(UUID.randomUUID().toString());
        dish.setName(dishVo.getName());
        dish.setPrice(dishVo.getPrice());
        dish.setNum(dishVo.getNum());
        dish.setPic(dishVo.getPic());
        boolean flag = dishMapper.insertDish(dish);
        return flag ? "OK" : "NO";
    }

    public String deleteDish(String did) {
        boolean flag = dishMapper.deleteDish(did);
        return flag ? "OK" : "NO";
    }

    public String updateDish(Dish dish) {
        boolean flag = dishMapper.updateDish(dish);
        return flag ? "OK" : "NO";
    }

    public List<Dish> queryAllDish() {
        return dishMapper.queryAllDish();
    }

}
