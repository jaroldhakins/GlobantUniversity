package org.globantUniversity.Data;

import java.util.ArrayList;
import java.util.List;


public class University {
    private String name;
    private List<Teacher> teacherList;
    private List<Student> studentList;
    private List<Subject> subjectList;

    public University(String name) {
        this.name = name;
        this.teacherList = new ArrayList<>();
        this.studentList = new ArrayList<>();
        this.subjectList = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public List<Subject> getSubjectList(){
        return this.subjectList;
    }

    public List<Student> getStudentList (){
        return this.studentList;
    }

    public List<Teacher> getTeacherList(){
        return this.teacherList;
    }

    public void enrollStudent(Student student){
        this.studentList.add(student);
    }

    public void loadTeacher(Teacher teacher){ this.teacherList.add(teacher); }

    public void addStudentToSubject(Subject subject, Student student) {
        subject.addStudents(student);
    }

    public Teacher getTeacher(int i){
        return this.teacherList.get(i);
    }

    public Subject addSubjectFull(String name, String classroom, Teacher teacher) {
        Subject subject = new Subject(name, classroom, (FullTimeTeacher) teacher);
        this.subjectList.add(subject);
        return subject;
    }

    public Subject addSubjectPart(String name, String classroom, Teacher teacher) {
        Subject subject = new Subject(name, classroom, (PartTimeTeacher) teacher);
        this.subjectList.add(subject);
        return subject;
    }



}
