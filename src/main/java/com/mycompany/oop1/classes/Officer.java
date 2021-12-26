package com.mycompany.oop1.classes;

public class Officer extends Employee {
    private String nameSurname;
    private int salary;

    public Officer(String nameSurname, int salary) {
        this.nameSurname = nameSurname;
        this.salary = salary;
    }

    public String getOfficerName() {
        return nameSurname;
    }

    public int getOfficerSalary() {
        return salary;
    }

    public int getCost() {
        return salary;
    }

    public void displayEmployeeInfo() {
     
        System.out.println("M " + getOfficerName() + " " + getCost());
    }

    @Override
    public String toString() {
        return "Officer [ " + super.toString() + "]";
    }

}
