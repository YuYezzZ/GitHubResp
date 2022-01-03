package com.yuye.command;

import java.util.HashMap;

public class Order {
    private HashMap<String,Integer> map= new HashMap<String , Integer>();;
    private int desk;
    public void add(String name,Integer num){
        map.put(name,num);
    }

    public Order(int desk) {
        this.desk = desk;
    }

    public HashMap<String, Integer> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Integer> map) {
        this.map = map;
    }

    public int getDesk() {
        return desk;
    }

    public void setDesk(int desk) {
        this.desk = desk;
    }
}
