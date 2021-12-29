package com.yuye.combination;

public abstract class MenuComponent {
    protected String name;
    protected int level;

    public MenuComponent(String name, int level) {
        this.name = name;
        this.level = level;
    }
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException("不支持添加子菜单");
    }
    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException("不支持移除子菜单");
    }
    public void select(int level){
        throw new UnsupportedOperationException("不支持查询子菜单");
    }
    public void print(){
        for (int i = 0; i < level; i++) {
            System.out.print("==");
        }
        System.out.println(name);
    }
}
