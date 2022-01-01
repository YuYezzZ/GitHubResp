package com.yuye.iterator;

import java.util.List;

public class StudentIterator implements Iterator<Student>{
    private List<Student> list;

    private int position = 0;
    @Override
    public boolean hasNext() {
        return position<list.size();
    }

    @Override
    public Student next() {
        Student student = list.get(position);
        position++;
        return student;

    }

    public StudentIterator(List<Student> list) {
        this.list = list;
    }
}
