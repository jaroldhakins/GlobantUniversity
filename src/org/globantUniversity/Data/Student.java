package org.globantUniversity.Data;

public class Student {
    private String name;
    private int dni;
    private int age;

    public Student(String name, int dni, int age){
        this.name = name;
        this.dni = dni;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return "Student name: " + this.name;
    }
}
