package com.yuye.factory.simplefactory;

public class CoffeeFactory {
    public Coffee creatCoffee(String str){
        return new Coffee();
    };
}
