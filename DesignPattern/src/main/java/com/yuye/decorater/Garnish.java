package com.yuye.decorater;

public abstract class Garnish extends FastFood{
    private FastFood food ;
    public Garnish( FastFood food,float price, String desc) {
        super(price, desc);
        this.food = food;
    }

    public FastFood getFood() {
        return food;
    }

    public void setFood(FastFood food) {
        this.food = food;
    }
}
