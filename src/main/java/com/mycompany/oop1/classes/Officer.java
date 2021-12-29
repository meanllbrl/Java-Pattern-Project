package com.mycompany.oop1.classes;

public class Officer extends Employee {
    public Officer(String nameSurname, int salary) {
        super(nameSurname, salary);
    }
    
    
    public void displayEmployeeInfo(boolean isCost) {
        System.out.print("\t");
        System.out.print("M " + getNameSurname() + " " + getSalary() + "\n");
    }

    @Override
    public String toString() {
        return "Officer [ " + super.toString() + "]";
    }

   

}
