package com.yuye.factory.abstractfactory;

public abstract class Coffee {

    public abstract String getName() ;

    //加糖
    public void addSugger(){
        System.out.println("加糖");
    }
    //加奶
    public void addMilk(){
        System.out.println("加奶");
    }
}
