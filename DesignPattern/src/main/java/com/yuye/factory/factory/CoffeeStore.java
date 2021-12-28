package com.yuye.factory.factory;

public class CoffeeStore {
    /*private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }*/

    //购买咖啡的方法
    public void buy(CoffeeFactory factory){
        Coffee coffee = factory.creatCoffee();
        coffee.addMilk();
        coffee.addSugger();
        System.out.println(coffee.getName());
    }
}
