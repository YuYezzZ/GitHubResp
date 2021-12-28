package com.yuye.prototype.Demo3;

import java.io.*;

public class Realizetype implements Serializable {
    private Student student ;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    //展示方法
    public void show(){
        System.out.println(this.student.getName()+"获得三好学生，特此奖励！");
    }
    @Override
    public String toString() {
        return "Realizetype1{" +
                "student=" + student +
                '}';
    }

    public Realizetype clone(){
        Realizetype r = new Realizetype();
        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\JavaFile\\clone.txt"));
            oos.writeObject(this);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\JavaFile\\clone.txt"));
            r = (Realizetype) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return r;
    }

}
