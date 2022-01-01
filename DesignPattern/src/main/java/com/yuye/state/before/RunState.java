package com.yuye.state.before;

public class RunState implements ILife{
    private int state;

    public RunState() {
        this.state = RUN_STATE;
    }

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public int getState() {
        return state;
    }
}
