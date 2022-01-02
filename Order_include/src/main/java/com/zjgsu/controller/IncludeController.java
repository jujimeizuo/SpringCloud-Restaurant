package com.zjgsu.controller;

import com.zjgsu.entity.JsonResult;
import com.zjgsu.entity.Order_include;
import com.zjgsu.service.IncludeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class IncludeController {
    @Autowired
    IncludeService includeService;

    @PostMapping("/add")
    public JsonResult addInclude(@RequestBody Order_include order_include){
        JsonResult jsonResult = includeService.addInclude(order_include);
        return jsonResult;
    }
    @RequestMapping("/delbyoid/{oid}")
    public JsonResult delincludebyoid(@PathVariable int oid){
        JsonResult jsonResult = includeService.delIncludeByoid(oid);
        return jsonResult;
    }
    @RequestMapping("/delbyuid/{uid}")
    public JsonResult delincludebyuid(@PathVariable int uid){
        JsonResult jsonResult = includeService.delIncludeByid(uid);
        return jsonResult;
    }

    @RequestMapping("/getbyid/{oid}")
    public JsonResult getbyidOrder(@PathVariable int oid){
        JsonResult jsonResult = includeService.getByid(oid);
        return jsonResult;
    }
    @PostMapping("/update")
    public JsonResult updateInclude(@RequestBody Order_include order_include){
        if(order_include.getNumber()<=0){
            return new JsonResult(400,"the number can'not min than 0",null);
        }
        JsonResult jsonResult = includeService.updateInclude(order_include);
        return jsonResult;
    }
}
