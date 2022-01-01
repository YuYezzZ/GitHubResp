package com.yuye.state.after;

public class Client {
    //程序入口
    public static void main(String[] args) {
        Context context = new Context(Context.OPEN_STATE);
        context.close();
        context.run();
        context.open();
    }
}
