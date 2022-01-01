package com.yuye.state.before;

public class Client {
    //程序入口
    public static void main(String[] args) {
        ILife openState = new RunState();
        openState.open();
        openState.close();
        openState.run();
        openState.stop();
    }
}
