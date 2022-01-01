package com.yuye.mediator;

public class Tenant extends Person{

    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    void constract(String msg) {
        getMediator().constract(msg,this);
    }
}
