package com.zjgsu.entity;

import lombok.Data;

@Data
public class UserAddRequest {
    private String phone;
    private String pass;
}