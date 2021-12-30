package com.yuye.responsibility;

public abstract class Handler {
    protected final int NUM_ONE = 1;
    protected final int NUM_THREE = 3;
    protected final int NUM_SEVEN = 7;
    protected int start;
    protected int end;

    abstract void audit (LeaveRequest leave);

    private Handler nextHandler;

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
