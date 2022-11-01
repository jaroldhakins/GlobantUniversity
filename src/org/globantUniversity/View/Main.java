package org.globantUniversity.View;

import org.globantUniversity.Data.Subject;
import org.globantUniversity.Data.Teacher;
import org.globantUniversity.Data.University;
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
                    break;
                case "4":
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
        for (Teacher teacher: university.getTeacherList()) {
            System.out.println(teacher.toString());
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
}