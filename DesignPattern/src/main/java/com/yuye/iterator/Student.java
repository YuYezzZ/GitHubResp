package com.yuye.iterator;

public class Student {
    private String name;
    private int sno;

    public Student(String name, int sno) {
        this.name = name;
        this.sno = sno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sno=" + sno +
                '}';
    }
}
