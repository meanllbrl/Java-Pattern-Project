package com.mycompany.oop1.classes;

public class Officer extends Employee {
    public Officer(String nameSurname, int salary) {
        super(nameSurname, salary);
    }

    public void displayEmployeeInfo() {
        System.out.print("\t");
        System.out.print("M " + getNameSurname() + " " + getCost() + "\n");
    }

    @Override
    public String toString() {
        return "Officer [ " + super.toString() + "]";
    }

   

}
