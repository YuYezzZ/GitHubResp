package com.yuye.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuye.enums.Gender;
import com.yuye.mapper.UserMapper;
import com.yuye.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

@ContextConfiguration(locations="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Test
    //自定义插件
    public void interceptor(){
        User user1 = new User();
        user1.setName("汤姆1");
        user1.setVersion(6);
        user1.setId(11L);
        user1.updateById();
        /*List<User> users = user1.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }*/
    }
    @Test
    //枚举类型
    public void select(){
        User user1 = new User();
        user1.setSex(Gender.WOMAN);
        user1.setVersion(2);
        user1.setId(12L);
        user1.updateById();
        List<User> users = user1.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    //逻辑删除
    public void logicDelete(){
        User user = new User();
        user.setId(11L);
        user.setVersion(2);
        boolean b = user.deleteById();
        System.out.println(b);
        List<User> users = userMapper.selectList(null);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
    @Test
    //阻断全表更新
    public void updateAll(){
        User user = new User();
        user.setAge(20);
        user.setVersion(1);
        user.update(null);
    }
    @Test
    //开启乐观锁
    public void lock(){
        User user = new User();
        user.setId(4L);
        user.setAge(23);
        user.setVersion(2);
        boolean b = user.updateById();
        System.out.println(b);
    }
    @Test
    //开启ActiveRecord
    public void selectById(){
        User user = new User();
        user.setId(4L);
        User user1 = user.selectById();
        System.out.println(user1);
    }
    @Test
    //selectList
    public void findAll(){
        List<User> users = this.userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
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
    @Test
    //selectPage
    public void selectTest1(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper.like("password","1");
//        userQueryWrapper.likeLeft("user_name","m");
        HashMap<String, Object> map = new HashMap<>();
        map.put("password","123456");
        map.put("user_name","tom");
        userQueryWrapper.allEq(map);
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void selectTest2(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        userQueryWrapper.ge("age",15);//>=
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void selectTest3(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        //userQueryWrapper.le("age",15);//<=
//        userQueryWrapper.select("user_name").le("age",15);//<=  select表示查询内容
//        userQueryWrapper.between("age",14,30);
//        userQueryWrapper.orderByDesc("age");
        userQueryWrapper.eq("age",20).or().eq("user_name","tom");
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
