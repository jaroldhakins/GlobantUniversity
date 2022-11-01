package org.globantUniversity.Data;

import java.util.Set;

public abstract class Teacher {
    protected String name;
    protected double salaryBase;

    Teacher (String name, double salaryBase){
        this.name = name;
        this.salaryBase = salaryBase;
    }

    public String getName(){
        return this.name;
    }

    public double getSalaryBase() {
        return salaryBase;
    }

    @Override
    public String toString(){
        return this.name + " " + this.salaryBase;
    }
}
