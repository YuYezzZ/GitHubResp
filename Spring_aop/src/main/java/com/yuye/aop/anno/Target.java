package com.yuye.aop.anno;

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("anno save running...");
        int i=1/0;
    }
}
