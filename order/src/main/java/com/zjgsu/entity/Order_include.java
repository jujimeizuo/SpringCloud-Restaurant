package com.zjgsu.entity;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "order_include")
public class Order_include {
    private int uid;
    private int oid;
    private int did;
}
