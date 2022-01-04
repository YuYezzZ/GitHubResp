package com.yuye.web;

import com.yuye.config.SpringConfiguration;
import com.yuye.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class UserController {
    //程序入口
    public static void main(String[] args) throws SQLException, PropertyVetoException {
        /*ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");*/
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = (UserService) app.getBean("userService");
        UserService userService2 = (UserService) app.getBean("userService");
        System.out.println(userService == userService2);
        userService.save();
        DataSource dataSource = (DataSource) app.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        app.close();
    }
}
