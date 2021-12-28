package com.yuye.factory.abstractfactory;

import com.yuye.factory.factory.AmericanCoffeeFactory;
import com.yuye.factory.factory.CoffeeFactory;

public class Client {
    //程序入口
    public static void main(String[] args) {
        DessertStore dessertStore = new DessertStore();
        DessertFactory factory = new AmericanDessertFactory();
        /*DessertFactory factory = new ItalyDessertFactory();*/

        dessertStore.buy(factory);
    }
}
