package com.yuye.aop;

public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("target save running...");
        int i=1/0;
    }
}
