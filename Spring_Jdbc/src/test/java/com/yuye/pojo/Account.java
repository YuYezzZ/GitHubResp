package com.yuye.pojo;

public class Account {
    private String username;
    private int age;

    public String getUserName() {
        return username;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public Account() {
    }

    public Account(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
