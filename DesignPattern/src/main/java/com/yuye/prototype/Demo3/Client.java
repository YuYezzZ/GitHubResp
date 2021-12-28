package com.yuye.prototype.Demo3;

public class Client {
    //程序入口
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("张三");
        Realizetype r = new Realizetype();
        r.setStudent(student);
        Realizetype r2 =r.clone();
        r2.getStudent().setName("李四");
        r.show();
        r2.show();
    }
}
