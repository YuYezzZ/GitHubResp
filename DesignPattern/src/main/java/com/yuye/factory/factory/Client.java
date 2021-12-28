package com.yuye.factory.factory;

import java.io.IOException;

public class Client {
    //程序入口
    public static void main(String[] args) throws IOException {
        CoffeeStore coffeeStore = new CoffeeStore();
        /*CoffeeFactory factory = new AmericanCoffeeFactory();*/
        CoffeeFactory factory = new LatteCoffeeFactory();

        coffeeStore.buy(factory);
    }
}
