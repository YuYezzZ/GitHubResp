package com.yuye.visitor;

public class Client {
    //程序入口
    public static void main(String[] args) {
        Home home = new Home();
        Cat cat = new Cat();
        Dog dog = new Dog();
        home.addAnimal(cat);
        home.addAnimal(dog);
        home.action(new Someone());
    }
}
