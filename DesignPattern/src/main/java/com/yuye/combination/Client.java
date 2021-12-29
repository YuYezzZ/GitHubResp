package com.yuye.combination;

public class Client {
    //程序入口
    public static void main(String[] args) {
        Menu menu1 = new Menu("角色管理",2);
        menu1.add(new MenuItem("新增角色",3));
        menu1.add(new MenuItem("修改角色",3));
        menu1.add(new MenuItem("删除角色",3));
        Menu menu2 = new Menu("权限管理",2);
        menu2.add(new MenuItem("新增权限",3));
        menu2.add(new MenuItem("修改权限",3));
        menu2.add(new MenuItem("删除权限",3));
        Menu menu3 = new Menu("后台管理",2);
        menu3.add(new MenuItem("增加后台",3));
        menu3.add(new MenuItem("删除后台",3));
        Menu menu = new Menu("系统管理", 1);
        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);
        menu.print();
        menu.select(2);
    }
}
