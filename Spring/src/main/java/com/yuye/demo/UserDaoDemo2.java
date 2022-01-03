package com.yuye.demo;

import com.yuye.dao.UserDao;
import com.yuye.dao.impl.UserDaoImpl3;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserDaoDemo2 {
    //程序入口
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao2 = (UserDao) app.getBean("userDao2");
        userDao2.save();
        System.out.println("=======================分割线====================");
        UserDao userDao3 = (UserDao) app.getBean("userDao3");
        userDao3.save();
        System.out.println("=======================引用其他配置文件====================");
        ClassPathXmlApplicationContext app1 = new ClassPathXmlApplicationContext("applicationContext-demo.xml");
        UserDao userDao3_2 = (UserDao) app1.getBean("userDao3");
        userDao3_2.save();
        System.out.println("=======================引用本地配置文件====================");
        FileSystemXmlApplicationContext app2 = new FileSystemXmlApplicationContext("E:\\JavaFile\\IDEA_workspace\\Spring\\src\\main\\resources\\applicationContext-demo.xml");
        UserDao userDao3_3 = (UserDao) app2.getBean("userDao3");
        userDao3_3.save();
        System.out.println("=======================getBean第二种方式====================");
        FileSystemXmlApplicationContext app3 = new FileSystemXmlApplicationContext("E:\\JavaFile\\IDEA_workspace\\Spring\\src\\main\\resources\\applicationContext-demo.xml");
        UserDaoImpl3 userDao3_4 = app3.getBean(UserDaoImpl3.class);
        userDao3_4.save();
    }
}
