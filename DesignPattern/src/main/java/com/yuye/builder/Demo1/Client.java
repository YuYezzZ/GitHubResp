package com.yuye.builder.Demo1;

public class Client {
    //程序入口
    public static void main(String[] args) {
        Bike bike = Director.creatBike();
        System.out.println(bike);
    }
}
