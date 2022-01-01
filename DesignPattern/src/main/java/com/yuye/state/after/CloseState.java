package com.yuye.state.after;

public class CloseState extends LifeState{


    @Override
    void open() {
        System.out.println("电梯门打开了");
        this.getContext().setLifeState(new OpenState());
    }


    @Override
    void close() {
        System.out.println("电梯门关闭了");
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
