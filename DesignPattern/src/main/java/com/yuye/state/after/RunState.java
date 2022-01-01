package com.yuye.state.after;

public class RunState extends LifeState{



    @Override
    void open() {

    }


    @Override
    void close() {

    }

    @Override
    void run() {
        System.out.println("电梯正在运行");
        this.getContext().setLifeState(Context.RUN_STATE);
    }

    @Override
    void stop() {
        System.out.println("电梯已停止");
        this.getContext().setLifeState(Context.STOP_STATE);
    }
}
