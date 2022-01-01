package com.zjgsu.restaurant.user1.controller;

import com.zjgsu.restaurant.user1.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    /**
     *  获取一个学生
     * @return JSON对象
     * */
    @GetMapping(value = "/detail")
    public Object getStudent () throws InterruptedException {
        TimeUnit.SECONDS.sleep(6);
        Student student = new Student();
        student.setName("张三");
        student.setAge(18);
        return student;
    }

}
