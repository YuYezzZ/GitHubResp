package com.yuye.factory.abstractfactory;

public class AmericanDessertFactory implements DessertFactory {

    @Override
    public Coffee creatCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert creatDessert() {
        return new Tiramisu();
    }
}
