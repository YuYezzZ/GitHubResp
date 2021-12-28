package com.yuye.adapter;

public class SDcardImpl implements SDcard{

    @Override
    public String readSD() {
        return "SD卡读取数据：hello world！";
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SD卡写入数据");
    }
}
