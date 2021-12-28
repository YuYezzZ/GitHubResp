package com.yuye.decorater;

public class Client {
    //程序入口
    public static void main(String[] args) {
        FastFood food = new FriedRice();
        System.out.println(food.getDesc()+food.cost());
        Egg egg = new Egg(food);
        System.out.println(egg.getDesc() + egg.cost());
    }
}
