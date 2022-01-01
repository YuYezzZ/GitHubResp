package com.yuye.visitor;

public class Dog implements Animal{
    @Override
    public void acceptEvent(Person person) {
        person.event(this);
        System.out.println("好好吃，汪汪汪~~~");
    }
}
