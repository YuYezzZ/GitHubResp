package com.yuye.combination;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent{
    private List<MenuComponent> menuList = new ArrayList<>();
    public Menu(String name, int level) {
        super(name, level);
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuList.remove(menuComponent);
    }

    @Override
    public void select(int level) {
        for (MenuComponent menuComponent : menuList) {
           if ( level== menuComponent.level ) System.out.println(menuComponent.name);
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("==");
        }
        System.out.println(name);
        for (MenuComponent menuComponent : menuList) {
           menuComponent.print();
        }
    }
}
