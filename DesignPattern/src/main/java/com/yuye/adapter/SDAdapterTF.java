package com.yuye.adapter;

public class SDAdapterTF  implements SDcard{

    private TFcard tFcard = new TFImpl();
    @Override
    public String readSD() {

        return  tFcard.readTF();
    }

    @Override
    public void writeSD(String msg) {

    }
}
