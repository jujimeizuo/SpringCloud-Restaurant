package com.zjgsu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String uname;
    @JsonIgnore
    private String upass;
    @JsonIgnore
    private String repass;
    @JsonIgnore
    private String repasstime;
//    private String email;
    private String phone;
//    private String sex;
//    private String birthday;
//    private String qq;
//    private String wechat;
}
