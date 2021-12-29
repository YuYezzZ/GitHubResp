package com.yuye.flyweight;

import java.util.HashMap;

public class Client {
    //程序入口
    public static void main(String[] args) {
        GetBoxFactory factory = GetBoxFactory.getFactory();
        HashMap<String, AbstractBox> map = factory.getMap();
        AbstractBox i1 = map.get("I");
        AbstractBox i2 = map.get("L");
        AbstractBox i3 = map.get("T");
        AbstractBox i4 = map.get("T");
        i1.display("red");
        i2.display("green");
        i3.display("yellow");
        i4.display("black");
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }
}
