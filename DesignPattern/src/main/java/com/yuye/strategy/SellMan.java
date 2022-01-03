package com.yuye.strategy;public class SellMan {
    private Strategy strategy;

    public SellMan(Strategy strategy) {
        this.strategy = strategy;
    }
    //展示促销活动
    public void show(){
        strategy.promotion();
    }
}
