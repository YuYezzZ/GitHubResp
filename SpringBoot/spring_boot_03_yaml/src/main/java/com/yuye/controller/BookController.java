package com.yuye.controller;

import com.yuye.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yuye
 * @Date: 2022/1/13 - 01 - 13 - 20:37
 * @Description: springboot 快速入门
 * @version: 1.0
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Value("${name1}")
    private String str;
    @Value("${age}")
    private int num;
    @Value("${strs1[2]}")
    private String strs;
    @Value("${user1.name}")
    private String name;
    @Value("${user2.age}")
    private int age;
    @Value("${users1[0].name}")
    private String name2;
    @Value("${users2[1].age}")
    private int age2;
    @Value("${userDir}")
    private String dir;
    @Value("${userDir2}")
    private String dir2;
    @Value("${userDir3}")
    private String dir3;
    @Value("${userDir4}")
    private String dir4;
//    获取配置文件的所有属性
    @Autowired
    private Environment environment;
//    自动获取配置文件属性并封装成对象
    @Autowired
    private User user;
    //获取yaml配置文件的属性
    @GetMapping
    public void getValue(){
        System.out.println(str);
        System.out.println(num);
        System.out.println(strs);
        System.out.println(name);
        System.out.println(age);
        System.out.println(name2);
        System.out.println(age2);
        System.out.println(dir);
        System.out.println(dir2);
        System.out.println(dir3);
        System.out.println(dir4);
        String name3 = environment.getProperty("name1");
        System.out.println(name3);
        String user1 = environment.getProperty("user1.name");
        System.out.println(user1);
        String users1 = environment.getProperty("users1[1].name");
        System.out.println(users1);
        System.out.println(user);
    }
}
