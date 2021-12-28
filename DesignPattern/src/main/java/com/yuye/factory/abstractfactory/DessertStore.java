package com.yuye.factory.abstractfactory;

public class DessertStore {
    /*private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }*/

    //购买咖啡的方法
    public void buy(DessertFactory factory){
        Coffee coffee = factory.creatCoffee();
        Dessert dessert = factory.creatDessert();
        coffee.addMilk();
        coffee.addSugger();
        dessert.show();
        System.out.println(coffee.getName());
    }
}
