package com.yuye.state.after;

public class Context {
    public static final LifeState OPEN_STATE = new OpenState();
    public static final LifeState CLOSE_STATE = new CloseState();
    public static final LifeState RUN_STATE = new RunState();
    public static final LifeState STOP_STATE = new StopState();

    private LifeState lifeState;

    public LifeState getLifeState() {
        return lifeState;
    }

    public void setLifeState(LifeState lifeState) {
        this.lifeState = lifeState;
        this.lifeState.setContext(this);
    }
    public void open(){
        lifeState.open();
    }
    public void close(){
        lifeState.close();
    }
    public void run(){
        lifeState.run();
    }
    public void stop(){
        lifeState.stop();
    }

    public Context(LifeState lifeState) {
        this.lifeState = lifeState;
        this.lifeState.setContext(this);
    }
}
