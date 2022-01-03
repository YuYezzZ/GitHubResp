package com.yuye.command;

import java.util.Set;

public class Cooker {


    //做菜
    public void cook(Order order){
        System.out.println(order.getDesk()+"桌的订单===========");
        Set<String> strings = order.getMap().keySet();
        for (String string : strings){
            Integer integer = order.getMap().get(string);
            System.out.println(integer+"份"+string);
        }
        System.out.println("做好了");
    }
}
