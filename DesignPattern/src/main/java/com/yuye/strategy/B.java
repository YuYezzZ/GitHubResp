package com.yuye.strategy;

public class B extends Strategy{
    @Override
    void promotion() {
        System.out.println("B方法：满400,打9折");
    }
}
