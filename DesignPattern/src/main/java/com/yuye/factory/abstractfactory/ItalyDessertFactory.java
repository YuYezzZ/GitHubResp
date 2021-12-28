package com.yuye.factory.abstractfactory;

public  class ItalyDessertFactory implements DessertFactory {

    @Override
    public Coffee creatCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert creatDessert() {
        return new Pudding();
    }
}
