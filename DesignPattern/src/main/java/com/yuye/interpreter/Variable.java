package com.yuye.interpreter;

public class Variable implements AbstractExpression{
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int interpret(Context context) {
        return context.getValue(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
