package com.yuye.aop.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {
    @Before("execution(public void com.yuye.aop.anno.Target.save())")
    public void before(){
        System.out.println("前置增强");
    }
    @AfterReturning("myPointcut()")
    public void after_returning(){
        System.out.println("后置增强");
    }
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕增强前");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕增强后");
        return proceed;
    }
    @AfterThrowing("myPointcut()")
    public void after_throwing(){
        System.out.println("抛出异常方法");
    }

   @After("MyAspect.myPointcut()")
    public void after(){
        System.out.println("最终方法");
    }

    @Pointcut("execution(public void com.yuye.aop.anno.Target.save())")
    public void myPointcut(){}
}
