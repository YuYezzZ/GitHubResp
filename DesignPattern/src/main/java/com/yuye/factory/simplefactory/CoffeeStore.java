package com.yuye.factory.simplefactory;

public class CoffeeStore {
    //购买咖啡的方法
    public void buy(){
        CoffeeFactory coffeeFactory = new Coffee();
        Coffee coffee = coffeeFactory.creatCoffee("american");
        coffee.addMilk();
        coffee.addSugger();
        coffee.getName();
        System.out.println(coffee.getName());
    }
}
