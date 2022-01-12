package com.yuye.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuye.mapper.UserMapper;
import com.yuye.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@ContextConfiguration(locations="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Test
    //selectList
    public void selectList(){
        List<User> users = this.userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    //selectPage
    public void selectPage(){
        Page<User> userPage1 = new Page<User>(2  ,1);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("password","1");
        IPage<User> userPage =  userMapper.selectPage(userPage1, null);
        System.out.println("分页总页数:"+userPage.getPages());
        System.out.println("总条数:"+userPage.getTotal());
        System.out.println("当前页面:"+userPage.getCurrent());
        System.out.println("当前页面条数:"+userPage.getSize());
        List<User> records = userPage.getRecords();
        for (User record : records) {
            System.out.println("页面数据"+record);
        }
    }
    @Test
    public void insert(){
        User user = new User();
        user.setUserName("tom");
        user.setPassword("123456");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user.getId());
    }
}
