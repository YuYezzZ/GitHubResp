package com.yuye.bridge;

public class Windows implements OS{

    @Override
    public void play(VedioStyle vedioStyle) {
        System.out.println("windows");
        vedioStyle.show();
    }
}
