package com.yuye.factory.simplefactory;

public class Coffee extends CoffeeFactory {
    private String name;

    public String getName() {
        return name;
    }

    //加糖
    public void addSugger(){
        System.out.println("加糖");
    }
    //加奶
    public void addMilk(){
        System.out.println("加奶");
    }

    @Override
    public Coffee creatCoffee(String str) {
        if ("american".equals(str)) return new AmericanCoffee() ;
        else if("latte".equals(str)) return new LatteCoffee();
        else throw new RuntimeException("请选择正确的咖啡");
    }
}
