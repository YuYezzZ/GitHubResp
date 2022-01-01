package com.yuye.iterator;

import java.util.ArrayList;
import java.util.List;

public class StudentAggregateImpl implements StudentAggregate{
    private List<Student> list = new ArrayList<>();
    @Override
    public void add(Student student) {
        list.add(student);
    }

    @Override
    public void remove(Student student) {
        list.remove(student);
    }

    @Override
    public Iterator<Student> getIterator() {
        return new StudentIterator(this.list);
    }
}
