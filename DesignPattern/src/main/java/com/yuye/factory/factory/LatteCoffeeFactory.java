package com.yuye.factory.factory;

public class LatteCoffeeFactory implements CoffeeFactory{

    @Override
    public Coffee creatCoffee() {
        return new LatteCoffee();
    }
}
