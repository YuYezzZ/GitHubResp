package com.yuye.prototype.Demo2;

public class Realizetype implements Cloneable{
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

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
