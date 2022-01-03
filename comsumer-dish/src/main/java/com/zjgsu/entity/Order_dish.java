package com.zjgsu.entity;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Data
public class Order_dish {
    private int id;//订单id
    private int cid;//订单用户id
    private Date submitTime;//订单提交时间
    private int state;//送达状态 0为未送达 1为送达
}
