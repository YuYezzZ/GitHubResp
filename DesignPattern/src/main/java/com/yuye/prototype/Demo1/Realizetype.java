package com.yuye.prototype.Demo1;

public class Realizetype implements Cloneable{
    private String name ;

    //测试方法
    public void show(){
        System.out.println(this.name+"同学获得三好学生，特此奖励！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
