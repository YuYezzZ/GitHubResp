package com.yuye.bridge;

public class Client {
    //程序入口
    public static void main(String[] args) {
        OS os = new Mac();
        os.play(new Avi());
    }
}
