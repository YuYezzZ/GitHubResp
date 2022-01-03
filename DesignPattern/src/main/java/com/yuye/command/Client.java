package com.yuye.command;

public class Client {
    //程序入口
    public static void main(String[] args) {
        Waitor waitor = new Waitor();
        Order order1 = new Order(1);
        order1.add("番茄鸡蛋",1);
        order1.add("米饭",2);
        Order order2 = new Order(2);
        order2.add("黄焖鸡",1);
        order2.add("米饭",3);
        Cooker cooker = new Cooker();
        Command command1 = new OrderCommand(cooker,order1);
        Command command2 = new OrderCommand(cooker,order2);
        waitor.add(command1);
        waitor.add(command2);
        waitor.submit();
    }
}
