package com.yuye.state.before;

public interface ILife {
    int OPEN_STATE = 1;
    int CLOSE_STATE = 2;
    int RUN_STATE = 3;
    int STOP_STATE = 4;
    void setState(int state);
    int getState();
    default void open(){
        switch(getState()){
            case OPEN_STATE  :
            case CLOSE_STATE  :
            case STOP_STATE  :
                System.out.println("电梯门已开启！");
                setState(OPEN_STATE);
                break;
            case RUN_STATE  :
                break;
        }
    }
    default void close() {
        switch (getState()) {
            case OPEN_STATE:
            case CLOSE_STATE:
            case STOP_STATE:
                System.out.println("电梯门已关闭！");
                setState(CLOSE_STATE);
                break;
            case RUN_STATE:
                break;

        }
    }
    default void run() {
        switch (getState()) {
            case RUN_STATE:
            case CLOSE_STATE:
            case STOP_STATE:
                System.out.println("电梯正在运行！");
                setState(RUN_STATE);
                break;
            case OPEN_STATE:
                break;

        }
    }
    default void stop() {
        switch (getState()) {
            case RUN_STATE:
            case CLOSE_STATE:
            case STOP_STATE:
                System.out.println("电梯已停止！");
                setState(STOP_STATE);
                break;
            case OPEN_STATE:
                break;
        }
    }
}
