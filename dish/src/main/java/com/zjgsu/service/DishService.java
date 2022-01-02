package com.zjgsu.service;

import com.zjgsu.pojo.Dish;
import com.zjgsu.service.vo.DishVo;

import java.util.List;

public interface DishService {

    String insertDish(DishVo dishVo) ;

    String deleteDish(String did) ;

    String updateDish(Dish dish) ;

    List<Dish> queryAllDish() ;

}
