package com.yuye.mediator;

public class HouseOwner extends Person{

    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    void constract(String msg) {
        getMediator().constract(msg,this);
    }
}
