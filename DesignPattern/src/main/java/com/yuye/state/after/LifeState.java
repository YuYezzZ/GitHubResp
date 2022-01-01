package com.yuye.state.after;

public abstract class LifeState {
    private Context context;


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    abstract void open();
    abstract void close();
    abstract void run();
    abstract void stop();
}
