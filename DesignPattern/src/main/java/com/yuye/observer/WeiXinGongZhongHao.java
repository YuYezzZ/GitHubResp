package com.yuye.observer;

import java.util.ArrayList;
import java.util.List;

public class WeiXinGongZhongHao implements Subject{
    private List<Observer> list = new ArrayList<>();
    @Override
    public void add(Observer ob) {
        list.add(ob);
    }

    @Override
    public void remove(Observer ob) {
        list.remove(ob);
    }

    @Override
    public void update(String str) {
        for (Observer observer : list) {
            observer.update(str);
        }
    }
}
