package com.yuye.iterator;

public class Client {
    //程序入口
    public static void main(String[] args) {
        Student s1 = new Student("张三", 1);
        Student s2 = new Student("李四", 2);
        Student s3= new Student("王五", 3);
        Student s4 = new Student("赵六", 4);
        StudentAggregateImpl aggregate = new StudentAggregateImpl();
        aggregate.add(s1);
        aggregate.add(s3);
        aggregate.add(s2);
        aggregate.add(s4);
        Iterator<Student> iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
