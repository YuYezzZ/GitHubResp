package com.yuye.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyTest {
    //程序入口
    public static void main(String[] args) {
        Target target = new Target();
        Advice advice = new Advice();

//        1.创建增强器
        Enhancer enhancer = new Enhancer();
//        2.设置父类
        enhancer.setSuperclass(target.getClass());
//        3.设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before();
                Object invoke = method.invoke(target, null);
                advice.after();
                return invoke;
            }
        });
//        创建代理对象
       Target proxy = (Target) enhancer.create();
       proxy.save();
    }
}
