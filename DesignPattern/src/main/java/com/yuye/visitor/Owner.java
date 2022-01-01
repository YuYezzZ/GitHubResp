package com.yuye.visitor;

public class Owner implements Person{
    @Override
    public void event(Dog dog) {
        System.out.println("我是主人，我要喂狗了");
    }

    @Override
    public void event(Cat cat) {
        System.out.println("我是主人，我要喂猫了");
    }
}
