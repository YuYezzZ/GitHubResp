
package com.yuye.bridge;

public class Mac implements OS{

    @Override
    public void play(VedioStyle vedioStyle) {
        System.out.println("Mac");
        vedioStyle.show();
    }
}
