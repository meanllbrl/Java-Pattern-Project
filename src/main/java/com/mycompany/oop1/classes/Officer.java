package com.mycompany.oop1.classes;

public class Officer extends Employee {
    private String nameSurname;
    private int salary;

    public Officer(String nameSurname, int salary) {
        super(nameSurname, salary);
    }

    public int getCost() {
        return salary;
    }

    public void displayEmployeeInfo() {
        System.out.print("\t");
        System.out.print("M " + nameSurname + " " + getCost() + "\n");
    }

    @Override
    public String toString() {
        return "Officer [ " + super.toString() + "]";
    }

   

}
