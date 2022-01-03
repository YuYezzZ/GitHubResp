package com.yuye.strategy;

public class C extends Strategy{
    @Override
    void promotion() {
        System.out.println("C方法：满500-50，超过500部分打9折");
    }
}
