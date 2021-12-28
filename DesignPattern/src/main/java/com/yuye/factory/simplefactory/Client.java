package com.yuye.factory.simplefactory;

public class Client {
    //程序入口
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        coffeeStore.buy();
    }
}
