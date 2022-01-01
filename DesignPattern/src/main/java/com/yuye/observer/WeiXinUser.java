package com.yuye.observer;

public class WeiXinUser implements Observer{
    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String str) {
        System.out.println(name+"关注的公众号更新了内容："+str);
    }
}
