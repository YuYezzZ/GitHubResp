package com.yuye.factory.factory;

public class AmericanCoffeeFactory implements CoffeeFactory{

    @Override
    public Coffee creatCoffee() {
        return new AmericanCoffee();
    }
}
