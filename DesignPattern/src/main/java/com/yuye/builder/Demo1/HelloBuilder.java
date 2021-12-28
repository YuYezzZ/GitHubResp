package com.yuye.builder.Demo1;

public class HelloBuilder implements Builder{
    @Override
    public String createPartA() {
        return "A2";
    }

    @Override
    public String createPartB() {
        return "B2";
    }
}
