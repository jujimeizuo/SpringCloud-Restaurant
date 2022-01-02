package com.zjgsu.mapper;

import com.zjgsu.pojo.Dish;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishMapper {

    /**
     * 插入新菜品
     * @param dish
     */
    Boolean insertDish(Dish dish);

    /**
     * 根据did删除菜品
     * @param did
     */
    Boolean deleteDish(String did);

    /**
     * 更新菜品
     * @param dish
     */
    Boolean updateDish(Dish dish);

    /**
     * 查询所有菜品
     * @return
     */
    List<Dish> queryAllDish() ;
}
