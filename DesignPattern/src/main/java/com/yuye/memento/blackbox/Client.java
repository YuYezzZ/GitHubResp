package com.yuye.memento.blackbox;


public class Client {
    //程序入口
    public static void main(String[] args) {
        GameRole gameRole = new GameRole();
        gameRole.getInit();
        MementoAdmin mementoAdmin = gameRole.setMemento();
        System.out.println("=================大战Boss前===============");
        System.out.println(gameRole);
        System.out.println("=================大战Boss后===============");
        gameRole.fight();
        System.out.println(gameRole);
        System.out.println("=================恢复存档===============");
        gameRole.rollBack(mementoAdmin);
        System.out.println(gameRole);
    }
}
