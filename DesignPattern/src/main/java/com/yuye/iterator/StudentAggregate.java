package com.yuye.iterator;

public interface StudentAggregate{
    void add(Student student);
    void remove(Student student);
    Iterator<Student> getIterator();
}
