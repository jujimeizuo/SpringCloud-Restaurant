package com.zjgsu.service;

import com.zjgsu.entity.JsonResult;
import com.zjgsu.entity.Order_include;

public interface IncludeService {
    JsonResult addInclude(Order_include order_include);
    JsonResult delIncludeByoid(int oid);
    JsonResult delIncludeByid(int uid);
    JsonResult getByid(int uid);
    JsonResult updateInclude(Order_include include);
}
