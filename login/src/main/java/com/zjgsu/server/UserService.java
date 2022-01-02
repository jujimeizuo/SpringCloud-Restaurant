package com.zjgsu.server;

import com.zjgsu.entity.Result;
import com.zjgsu.entity.User;
import com.zjgsu.repository.UserReponsitory;
import com.zjgsu.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserReponsitory userReponsitory;

    boolean findByPhone(String phone){
        return userReponsitory.existsUserByPhone(phone);
    }
    public List<User> saveUser(User user)
    {
        List<User> list = new ArrayList<>();
        list.add(userReponsitory.save(user));
        return list;
    }
    public Result<List<User>> reg(String phone, String pass){
        if(findByPhone(phone)){
            return new Result<>("用户已存在",-1);
        }
        else{
            User user = new User();
            user.setPhone(phone);
            user.setUpass(Md5.md5(pass));
            return new Result<>(saveUser(user));
        }
    }
    public Result<List<User>> log(String phone, String pass){
        if(!findByPhone(phone)){
            return new Result<>("用户不存在", -1);
        }
        List<User> list = userReponsitory.findUserByPhone(phone);
        String nopass = Md5.md5(pass);
        if(list.get(0).getUpass().equals(nopass)){
            return new Result<>(list);
        }
        else return new Result<>("密码错误",-2);
    }
}
