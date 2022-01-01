package com.yuye.state.before;

public class CloseState implements ILife{
    private int state;

    public CloseState() {
        this.state = CLOSE_STATE;
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
