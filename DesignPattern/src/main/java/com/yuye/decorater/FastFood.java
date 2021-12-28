package com.yuye.decorater;

public abstract  class FastFood {
    private float price;
    private String desc;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    //付款方法
    public abstract float cost();

    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

}
