package com.zjgsu.controller;

import com.zjgsu.pojo.Dish;
import com.zjgsu.pojo.Result;
import com.zjgsu.pojo.ResultCode;
import com.zjgsu.service.DishService;
import com.zjgsu.service.vo.DishVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class DishController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private DishService dishService;

    @PostMapping(value = "/insertDish")

    public Result insertDish(@RequestBody DishVo dishVo) {
        String msg = dishService.insertDish(dishVo);
        Result result = new Result().code(ResultCode.SUCCESS).message(msg);
        log.info("port: " + port + "------新增: " + result.toString());
        return result;
    }

    @GetMapping(value = "/deleteDish/{did}")
    public Result deleteDish(@PathVariable String did) {
        Result result;
        String msg = dishService.deleteDish(did);
        result = new Result().code((!msg.equals("OK") ? ResultCode.ERROR : ResultCode.SUCCESS)).message(msg);
        log.info("port: " + port + "------删除: " + result.toString());
        return result;
    }

    @PostMapping(value = "/updateDish")
    public Result updateDish(@RequestBody Dish dish) {
        Result result;
        String msg = dishService.updateDish(dish);
        result = new Result().code((!msg.equals("OK") ? ResultCode.ERROR : ResultCode.SUCCESS)).message(msg);
        log.info("port: " + port + "------更新: " + result.toString());
        return result;
    }

    @PostMapping(value = "/queryAllDish")
    public Result queryAllDish() {
        Result result;
        List<Dish> dishes = dishService.queryAllDish();
        result = new Result().code(ResultCode.SUCCESS).message("查询所有信息").data("dishes", dishes);
        log.info("port: " + port + "------查询菜品所有信息: " + result.toString());
        return result;
    }

    @GetMapping(value = "/queryDishByDid/{did}")
    public Result queryDishByDid(@PathVariable String did) {
        Result result;
        Dish dish = dishService.queryDishByDid(did);
        result = new Result().code(ResultCode.SUCCESS).message("查询did信息").data("dish", dish);
        log.info("port: " + port + "------查询did信息: " + result.toString());
        return result;
    }
}
