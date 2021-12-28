package com.yuye.proxy.activeproxy.cglibdemo;

public class Client {
    //程序入口
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        TrainTicketsSell proxyObject = factory.getProxyObject();
        proxyObject.sell();
    }
}
