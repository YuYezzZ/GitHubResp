package com.yuye;

import com.yuye.controller.BookController;
import com.yuye.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootMaven {
    //程序入口
    public static void main(String[] args) {
        /*
        * SpringApplication.run方法本质上是创建一个Spring容器 容器只能对调用该方法的包及其子包下的类进行实例化
        * */
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootMaven.class, args);
        BookController bookController = run.getBean(BookController.class);
        System.out.println("=====>"+bookController);
        User user = run.getBean(User.class);
        System.out.println("=====>"+user);
    }
}
