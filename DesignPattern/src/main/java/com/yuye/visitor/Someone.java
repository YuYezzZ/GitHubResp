package com.yuye.visitor;

public class Someone implements Person{
    @Override
    public void event(Dog dog) {
        System.out.println("我是其他人，我要喂狗了");
    }

    @Override
    public void event(Cat cat) {
        System.out.println("我是其他人，我要喂猫了");
    }
}
