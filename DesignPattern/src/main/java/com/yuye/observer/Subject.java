package com.yuye.observer;

public interface Subject {
    void add(Observer ob);
    void remove(Observer ob);
    void update(String str);
}
