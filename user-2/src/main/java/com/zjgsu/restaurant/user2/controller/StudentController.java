package com.zjgsu.restaurant.user2.controller;

import com.zjgsu.restaurant.user2.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    /**
     *  获取一个学生
     * @return JSON对象
     * */
    @GetMapping(value = "/detail")
    public Object getStudent () {
        Student student = new Student();
        //可以看到，我们没有在实体类写get和set方法，但是我们依然可以调用这些方法
        //这就是Lombok插件的好处，只需要在实体类加一个@Data注解
        student.setName("李四");
        student.setAge(26);
        return student;
    }

}