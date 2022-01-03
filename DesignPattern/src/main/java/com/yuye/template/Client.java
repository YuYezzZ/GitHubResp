package com.yuye.template;

public class Client {
    //程序入口
    public static void main(String[] args) {
        Cook cook = new CookBaoCai(new BaoCai(), new Sugar());
        cook.cook();
    }
}
