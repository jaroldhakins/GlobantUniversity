package org.globantUniversity.Data;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private String classroom;
    private Teacher teacher;
    private List<Student> studentList;

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


}
