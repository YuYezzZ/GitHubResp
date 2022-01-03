package com.yuye.strategy;

public class Client {
    //程序入口
    public static void main(String[] args) {
        SellMan sellMan = new SellMan(new B());
        sellMan.show();
    }
}
