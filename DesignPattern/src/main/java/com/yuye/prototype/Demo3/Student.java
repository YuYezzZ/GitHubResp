package com.yuye.prototype.Demo3;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
