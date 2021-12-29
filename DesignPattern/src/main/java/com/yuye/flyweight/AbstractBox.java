package com.yuye.flyweight;

public abstract class AbstractBox {
    public abstract String getShape();
    public void display(String color){
        System.out.println(color+getShape()+"方块");
    }
}
