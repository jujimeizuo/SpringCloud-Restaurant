package com.zjgsu.server;

import com.zjgsu.entity.Result;
import com.zjgsu.entity.User;
import com.zjgsu.repository.UserReponsitory;
import com.zjgsu.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserReponsitory userReponsitory;
    @Autowired
    private JavaMailSender javaMailSender;


    public void sendEmail(String address, String code)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("验证码");
        message.setFrom("kepadedaidai@163.com");
        message.setTo(address);
        message.setSentDate(new Date());
        message.setText("您的验证码是" + code + ",验证码10分钟内有效,如果这不是您的操作，请忽略这封邮件");
        javaMailSender.send(message);
    }
    boolean findByEmail(String email){
        return userReponsitory.existsUserByEmail(email);
    }
    public List<User> saveUser(User user)
    {
        List<User> list = new ArrayList<>();
        list.add(userReponsitory.save(user));
        return list;
    }
    public Result<List<User>> reg(String email, String pass, String tmpcode){
        if(!userReponsitory.existsUserByEmail(email)){
            return new Result<>("用户未发注册邮件", -1);
        }
        User user = userReponsitory.findUsersByEmail(email).get(0);
        long now = new Date().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date ned = sdf.parse(user.getRepasstime());
            long need = ned.getTime();
            if (now > need) {
                return new Result<>("验证码已过期", -2);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(!tmpcode.equals(user.getRepass())){
            return new Result<>("验证码错误", -3);
        }
        user.setUpass(Md5.md5(pass));
        return new Result<>(saveUser(user));
    }
    public Result<List<User>> log(String email, String pass){
        if(!findByEmail(email)){
            return new Result<>("用户不存在", -1);
        }
        List<User> list = userReponsitory.findUsersByEmail(email);
        String nowpass = Md5.md5(pass);
        if(list.get(0).getUpass().equals(nowpass)){
            return new Result<>(list);
        }
        else return new Result<>("密码错误",-2);
    }
    public Result<List<User>> sentEmail(String email){
        if(findByEmail(email)){
            User user = new User();
            user.setEmail(email);
            userReponsitory.save(user);
        }
        List<User> list = userReponsitory.findUsersByEmail(email);
        User user = list.get(0);
        int code = (int)((Math.random()*9+1)*100000);
        user.setRepass(Integer.toString(code));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        user.setRepasstime(sdf.format(new Date(now.getTime()+600000)));
        userReponsitory.save(user);
        sendEmail(email, user.getRepass());
        return new Result<>("success", 1);
    }
}
