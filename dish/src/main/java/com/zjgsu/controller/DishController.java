package com.zjgsu.controller;

import com.zjgsu.pojo.Dish;
import com.zjgsu.pojo.Result;
import com.zjgsu.pojo.ResultCode;
import com.zjgsu.service.DishService;
import com.zjgsu.service.vo.DishVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dish")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping(value = "/insertDish")
    public Result insertDish(@RequestBody DishVo dishVo) {
        String msg = dishService.insertDish(dishVo);
        Result result = new Result().code(ResultCode.SUCCESS).message(msg);
        log.info("新增: " + result.toString());
        return result;
    }

    @GetMapping(value = "/deleteDish/{did}")
    public Result deleteDish(@PathVariable String did) {
        Result result;
        String msg = dishService.deleteDish(did);
        result = new Result().code((!msg.equals("OK") ? ResultCode.ERROR : ResultCode.SUCCESS)).message(msg);
        log.info("删除: " + result.toString());
        return result;
    }

    @PostMapping(value = "/updateDish")
    public Result updateDish(@RequestBody Dish dish) {
        Result result;
        String msg = dishService.updateDish(dish);
        result = new Result().code((!msg.equals("OK") ? ResultCode.ERROR : ResultCode.SUCCESS)).message(msg);
        log.info("更新: " + result.toString());
        return result;
    }

    @PostMapping(value = "/queryAllDish")
    public Result queryAllDish() {
        Result result;
        List<Dish> dishes = dishService.queryAllDish();
        result = new Result().code(ResultCode.SUCCESS).message("查询").data("菜品", dishes);
        log.info("查询: " + result.toString());
        return result;
    }
}
