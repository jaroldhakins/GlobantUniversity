package org.globantUniversity.Data;

import java.util.Collection;
import java.util.Iterator;

public class FullTimeTeacher extends Teacher{

    private static int experienceYears;

    public FullTimeTeacher(String name, double salaryBase, int experienceYears){
        super(name, salaryBase);
        this.experienceYears = experienceYears;
    }

    public double calculateSalary(){
        return super.salaryBase * (experienceYears * 1.1);
    }

    @Override
    public String toString(){
        return super.toString() + " years of experience: " + this.experienceYears + " " + " Salary: " + this.calculateSalary();
    }
}
