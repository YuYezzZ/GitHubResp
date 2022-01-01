package com.yuye.state.before;

public class StopState implements ILife{
    private int state;

    public StopState() {
        this.state = STOP_STATE;
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
