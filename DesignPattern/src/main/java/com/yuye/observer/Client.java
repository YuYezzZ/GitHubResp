package com.yuye.observer;

public class Client {
    //程序入口
    public static void main(String[] args) {
        WeiXinGongZhongHao weiXinGongZhongHao = new WeiXinGongZhongHao();
        WeiXinUser user1 = new WeiXinUser("张三");
        WeiXinUser user2 = new WeiXinUser("李四");
        weiXinGongZhongHao.add(user1);
        weiXinGongZhongHao.add(user2);
        weiXinGongZhongHao.update("欢迎关注本公众号");
    }
}
