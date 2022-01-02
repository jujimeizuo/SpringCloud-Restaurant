package com.zjgsu.repository;

import com.zjgsu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserReponsitory extends JpaRepository<User, Integer> {



    boolean existsUserByUid(Integer id);

    boolean existsUserByEmail(String email);
    List<User> findUsersByEmail(String email);
    List<User> findUserByUid(Integer uid);
    boolean existsUserByPhone(String phone);
    List<User> findUserByPhone(String phone);
}