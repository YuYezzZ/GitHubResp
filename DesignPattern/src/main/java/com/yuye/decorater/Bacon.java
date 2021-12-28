package com.yuye.decorater;

public class Bacon extends Garnish{

    public Bacon(FastFood food) {
        super(food,2,"培根");

    }

    @Override
    public float cost() {
        return getPrice()+ getFood().cost();
    }
    public String getDesc(){
        return super.getDesc()+getFood().getDesc();
    }
}
