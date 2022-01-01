package com.yuye.state.after;

public class OpenState extends LifeState{


    @Override
    void open() {
        System.out.println("电梯门打开了");
        this.getContext().setLifeState(Context.OPEN_STATE);
    }

    @Override
    void close() {
        System.out.println("电梯门关闭了");
        this.getContext().setLifeState(Context.CLOSE_STATE);
    }

    @Override
    void run() {

    }

    @Override
    void stop() {

    }
}
