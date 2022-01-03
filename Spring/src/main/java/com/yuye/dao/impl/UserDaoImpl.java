package com.yuye.dao.impl;

import com.yuye.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
       /* System.out.println("userDaoImpl无参构造被调用");*/
    }
    //初始化方法
    public void init(){
        System.out.println("初始化方法");
    }
    //销毁方法
    public void destroy(){
        System.out.println("销毁方法");
    }
    @Override
    public void save() {
        System.out.println("user dao impl");
    }
}
