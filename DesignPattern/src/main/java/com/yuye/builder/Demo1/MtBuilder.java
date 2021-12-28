package com.yuye.builder.Demo1;

public class MtBuilder implements Builder{
    @Override
    public String createPartA() {
        return "A1";
    }

    @Override
    public String createPartB() {
        return "B1";
    }
}
