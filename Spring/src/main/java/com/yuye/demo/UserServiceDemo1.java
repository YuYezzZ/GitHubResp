package com.yuye.demo;

import com.yuye.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceDemo1 {
    //程序入口
    public static void main(String[] args) {
        /*UserServiceImpl userService = new UserServiceImpl();
        userService.save();*/
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
