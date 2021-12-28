package com.yuye.proxy.activeproxy.jdkdemo;

public class Client {
    //程序入口
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        TrainTickets proxyObject = proxyFactory.getProxyObject();
        proxyObject.sell();
    }
}
