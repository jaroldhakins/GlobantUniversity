package org.globantUniversity.View;

import org.globantUniversity.Data.*;
import org.globantUniversity.Persistence.DataInitializer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University university = DataInitializer.initializeUniversity();
        Scanner scan = new Scanner(System.in);
        boolean bool = false;

        do {
            System.out.println("-------Welcome to " + university.getName() + "---------");
            System.out.println("What do you want to do today?");
            System.out.println("Enter 1 to print all the professors with its data");
            System.out.println("Enter 2 to print all the classes and a submenu to select an specific class");
            System.out.println("Enter 3 to Create a new student and add it to an existing class");
            System.out.println("Enter 4 to Create a new class and add an existing teacher, existing students");
            System.out.println("Enter 5 to List all the classes in which a given student is included");
            System.out.println("Enter 6 to Exit");
            String option = scan.nextLine();
            switch (option) {
                case "1":
                    printTeachers(university);
                    break;
                case "2":
                    printSubjects(university);
                    break;
                case "3":
                    enrollNewStudent(university);
                    break;
                case "4":
                    createNewClass(university);
                    break;
                case "5":
                    break;
                case "6":
                    bool = true;
                    break;
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        } while (!bool);
    }

    public static void printTeachers(University university) {
        int i = 0;
        for (Teacher teacher: university.getTeacherList()) {
            System.out.println(i + ". " + teacher.toString());
            i++;
        }
    }

    public static void printSubjects(University university) {
        int i = 0;
        for (Subject subject : university.getSubjectList()) {
            System.out.println(i + ". " + subject.getName());
            i++;
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of the class you need details");
        Integer option = scan.nextInt();
        System.out.println(university.getSubjectList().get(option));
    }

    public static void printStudents(University university) {
        int i = 0;
        for (Student student: university.getStudentList()) {
            System.out.println(i + ". " + student.toString());
            i++;
        }
    }

    public static Student createNewStudent(University university) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the student");
        String name = scan.nextLine();
        System.out.println("Please write the document number");
        Integer dni = scan.nextInt();
        System.out.println("Add the age");
        Integer age = scan.nextInt();

        Student student = new Student(name, dni, age);
        university.enrollStudent(student);
        return student;
    }

    public static void enrollNewStudent(University university){
        Student student = createNewStudent(university);
        Scanner scan = new Scanner(System.in);
        System.out.println("In which of the following classes do you want to enroll the student");
        int i = 0;
        for (Subject subject : university.getSubjectList()) {
            System.out.println(i + ". " + subject.getName());
            i++;
        }
        System.out.println("Please enter the number of the class you want to enroll");
        Integer option = scan.nextInt();
        Subject subject = university.getSubjectList().get(option);
        university.addStudentToSubject(subject, student);
        System.out.println("#######-" + student.getName() + " have been enrolled with success\n");
    }

    public static void createNewClass(University university) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the class you want to add");
        String subjectName = scan.nextLine();
        System.out.println("What is the classroom assigned to this class");
        String classroom = scan.nextLine();
        Integer choice = 3;
        do {
            System.out.println("Type 1 if you want to add a new teacher to this class");
            System.out.println("Type 0 if you want to add an existing teacher to this class");
            choice = scan.nextInt();
            if (choice == 1) {
                Teacher teacher = createNewTeacher(university);
                university.addSubjectFull(subjectName, classroom, (FullTimeTeacher) teacher);
                break;
            } else  if (choice == 0){
                printTeachers(university);
                System.out.println("Type the index of the teacher do you need");
                Integer index = scan.nextInt();
                Teacher teacher = university.getTeacherList().get(index);
                if (index == 2 || index == 3) {
                    university.addSubjectPart(subjectName, classroom, (PartTimeTeacher) teacher);
                } else {
                    university.addSubjectFull(subjectName, classroom, (FullTimeTeacher) teacher);
                }
                break;
            } else {
                System.out.println("\n\n.......Invalid option........\n\n");
            }
        } while (choice == 3);

        boolean loop = false;
        do {
            System.out.println("Do you want to add more students to this class\n1. Sí\n2. No");
            Integer option = scan.nextInt();
            switch (option) {
                case 1:
                    printStudents(university);
                    System.out.println("Type the index of the student you want to add to this class");
                    Integer studentIndex = scan.nextInt();
                    Student student = university.getStudentList().get(studentIndex);
                    int loc = university.getSubjectList().size();
                    Subject subject = university.getSubjectList().get(loc - 1);
                    university.addStudentToSubject(subject, student);
                    break;
                case 2:
                    loop = true;
                    break;
                case 3:
                    System.out.println("Please enter a valid option");
                    break;
            }
        } while (!loop);


    }

    public static FullTimeTeacher createNewTeacher(University university) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name of the teacher");
        String teacherName = scan.nextLine();
        System.out.println("what is the base salary per hour");
        Integer baseSalary = scan.nextInt();
        System.out.println("How many years of experience");
        Integer experienceYears = scan.nextInt();
        FullTimeTeacher teacher = new FullTimeTeacher(teacherName, baseSalary, experienceYears);

        university.loadTeacher(teacher);
        return teacher;
    }
}