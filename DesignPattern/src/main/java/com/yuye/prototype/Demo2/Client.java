package com.yuye.prototype.Demo2;

public class Client {
    //程序入口
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("张三");
        Realizetype r = new Realizetype();
        r.setStudent(student);
        try {
            Realizetype r2 = (Realizetype) r.clone();
            r2.getStudent().setName("李四");
            r.show();
            r2.show();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
