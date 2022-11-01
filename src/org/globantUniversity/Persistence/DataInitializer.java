package org.globantUniversity.Persistence;

import org.globantUniversity.Data.Subject;
import org.globantUniversity.Data.Student;
import org.globantUniversity.Data.FullTimeTeacher;
import org.globantUniversity.Data.PartTimeTeacher;
import org.globantUniversity.Data.University;

public class DataInitializer {

    public static University initializeUniversity(){
        University myUniversity = new University("Globant University");
        loadUniversityStudents(myUniversity);
        loadUniversityTeachers(myUniversity);
        loadUniversitySubjects(myUniversity);
        return myUniversity;
    }

    public static void loadUniversitySubjects (University university) {
        Subject math = university.addSubjectFull("Math", "102", university.getTeacherList().get(0));
        Subject philosophy = university.addSubjectFull("philosophy", "103", university.getTeacherList().get(1));
        Subject physics = university.addSubjectPart("physics", "104", university.getTeacherList().get(2));
        Subject chemistry = university.addSubjectPart("chemistry", "105", university.getTeacherList().get(3));

    }

    private static void loadUniversityStudents (University university){
        Student student1 = new Student("Jarold Hakins", 1, 27);
        Student student2 = new Student("Mario Bross", 12, 40);
        Student student3 = new Student("Luigi 21", 123, 45);
        Student student4 = new Student("Maria Giraldo", 1234, 18);
        Student student5 = new Student("Ramon Valdes", 12345, 52);
        Student student6 = new Student("Carlos zemura", 123456, 22);

        university.enrollStudent(student1);
        university.enrollStudent(student2);
        university.enrollStudent(student3);
        university.enrollStudent(student4);
        university.enrollStudent(student5);
        university.enrollStudent(student6);
    }

    private static void loadUniversityTeachers(University university){
        FullTimeTeacher teacher1 = new FullTimeTeacher("Alberto Aguirre", 30.5, 15);
        FullTimeTeacher teacher2 = new FullTimeTeacher("Carla Giraldo", 40.0, 22);
        PartTimeTeacher teacher3 = new PartTimeTeacher("Carolina Azulgrana", 22.0, 20);
        PartTimeTeacher teacher4 = new PartTimeTeacher("Orlando Rengifo", 20.0, 20);

        university.loadTeacher(teacher1);
        university.loadTeacher(teacher2);
        university.loadTeacher(teacher3);
        university.loadTeacher(teacher4);
    }
}
