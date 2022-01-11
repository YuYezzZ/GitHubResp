package com.yuye.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void before(){
        System.out.println("前置增强");
    }
    public void after_returning(){
        System.out.println("后置增强");
    }
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕增强前");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕增强后");
        return proceed;
    }
    public void after_throwing(){
        System.out.println("抛出异常方法");
    }
    public void after(){
        System.out.println("最终方法");
    }
}
