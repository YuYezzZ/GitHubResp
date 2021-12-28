package com.yuye.proxy.activeproxy.cglibdemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private TrainTicketsSell trainTicketsSell = new TrainTicketsSell();

    public TrainTicketsSell getProxyObject(){

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(TrainTicketsSell.class);

        enhancer.setCallback(this);

        TrainTicketsSell proxyObject = (TrainTicketsSell) enhancer.create();

        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理收取一定的费用");
        Object object = method.invoke(this.trainTicketsSell, objects);
        return object;
    }
}
