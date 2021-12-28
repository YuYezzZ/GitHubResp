package com.yuye.adapter;

public class Client {
    //程序入口
    public static void main(String[] args) {
        SDcardImpl sDcard = new SDcardImpl();
        Computer computer = new Computer();
        String s = computer.readSD(sDcard);
        System.out.println(s);
        System.out.println("========================");
        SDAdapterTF sdAdapterTF = new SDAdapterTF();
        String s1 =  computer.readSD(sdAdapterTF);
        System.out.println(s1);
    }
}
