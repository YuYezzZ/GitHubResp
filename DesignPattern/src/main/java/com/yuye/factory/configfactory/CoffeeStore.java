package com.yuye.factory.configfactory;

import com.yuye.util.FactoryConfig;

import java.util.HashMap;

public class CoffeeStore {
    /*private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }*/

    //购买咖啡的方法
    public void buy(String name){
        HashMap<String, Coffee> map = FactoryConfig.getMap();
        Coffee coffee = map.get(name);
        coffee.addMilk();
        coffee.addSugger();
        System.out.println(coffee.getName());
    }
}
