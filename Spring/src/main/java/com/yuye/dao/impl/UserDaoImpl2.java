package com.yuye.dao.impl;

import com.yuye.dao.UserDao;

public class UserDaoImpl2 implements UserDao {
    private String userName;
    private int age;
    public UserDaoImpl2(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public UserDaoImpl2() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {
        System.out.println(userName + "======" + age);
    }
}
