package com.yuye.decorater;

public class Egg extends Garnish{

    public Egg(FastFood food) {
        super(food,1,"鸡蛋");

    }



    @Override
    public float cost() {
        return getPrice() + getFood().cost();
    }
    public String getDesc(){
        return super.getDesc()+getFood().getDesc();
    }
}
