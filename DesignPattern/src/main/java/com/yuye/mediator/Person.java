package com.yuye.mediator;

public abstract class Person {
    private String name;
    private Mediator mediator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    abstract void constract(String msg);

    public Person(String name,Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
