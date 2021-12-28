package com.yuye.proxy.activeproxy.jdkdemo;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private TrainTicketsSell trainTicketsSell = new TrainTicketsSell();
    public TrainTickets getProxyObject() {
        TrainTickets proxyObject = (TrainTickets)Proxy.newProxyInstance(
                trainTicketsSell.getClass().getClassLoader(),
                trainTicketsSell.getClass().getInterfaces(),
                new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object object = method.invoke(trainTicketsSell, args);
                        return object;
                    }
                });
        return proxyObject;
    }
}
