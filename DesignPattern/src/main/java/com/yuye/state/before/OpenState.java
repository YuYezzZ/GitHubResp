package com.yuye.state.before;

public class OpenState implements ILife{
    private int state;

    public OpenState() {
        this.state = OPEN_STATE;
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
