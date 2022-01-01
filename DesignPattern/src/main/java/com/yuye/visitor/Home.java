package com.yuye.visitor;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private List<Animal> list = new ArrayList<>();
    //添加动物
    public void addAnimal(Animal animal){
        list.add(animal);
    }
    //移除动物
    public void removeAnimal(Animal animal){
        list.remove(animal);
    }
    //访问动物事件方法
    public void action(Person person){
        for (Animal animal : list) {
            animal.acceptEvent(person);
        }
    }
}
