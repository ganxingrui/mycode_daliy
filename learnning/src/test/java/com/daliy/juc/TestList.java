package com.daliy.juc;

/**
 * @author Lenovo
 * @date 2020/7/26 15:08
 */
public class TestList {
    public static void main(String[] args) {
        final Student student = new Student();
        System.out.println(student.age1);
        System.out.println(student.age2);
    }


}

class Student{
     Integer age1;
     int age2;
}
