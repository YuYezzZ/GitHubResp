package com.yuye.visitor;

public class Cat implements Animal{
    @Override
    public void acceptEvent(Person person) {
        person.event(this);
        System.out.println("好好吃，喵喵喵~~~");
    }
}
