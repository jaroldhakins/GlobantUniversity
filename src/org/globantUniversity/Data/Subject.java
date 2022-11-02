package org.globantUniversity.Data;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private String classroom;
    private Teacher teacher;
    private List<Student> studentList;

    public String getName(){
        return this.name;
    }

    public Subject(){}

    public Subject (String name, String classroom, FullTimeTeacher teacher) {
        this.name = name;
        this.classroom = classroom;
        this.teacher = teacher;
        this.studentList = new ArrayList<>();
    }

    public Subject (String name, String classroom, PartTimeTeacher teacher) {
        this.name = name;
        this.classroom = classroom;
        this.teacher = teacher;
        this.studentList = new ArrayList<>();
    }

    public void addStudents(Student student){
        this.studentList.add(student);
    }

    @Override
    public String toString(){
        return "Subject: " + this.name +
                "\nClassroom: " + this.classroom +
                "\nTeacher: " + this.teacher.getName() +
                "\nStudents: " + this.studentList;

    }



}
