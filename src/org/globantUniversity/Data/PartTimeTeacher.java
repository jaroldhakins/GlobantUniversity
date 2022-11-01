package org.globantUniversity.Data;

import java.util.Collection;
import java.util.Iterator;

public class PartTimeTeacher extends Teacher{

    private int activeHours;

    public PartTimeTeacher(String name, double salaryBase, int activeHours){
        super(name, salaryBase);
        this.activeHours = activeHours;
    }

    public double calculateSalary() {
        return super.salaryBase * activeHours;
    }

    @Override
    public String toString(){
        return super.toString() + " Salary: " + " " + this.calculateSalary();
    }
}
