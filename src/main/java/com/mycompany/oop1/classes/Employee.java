package com.mycompany.oop1.classes;

public abstract class Employee {
    private String nameSurname;
    private int salary;

    public Employee(String nameSurname, int salary) {
        this.nameSurname = nameSurname;
        this.salary = salary;
    }

    public String getNameSurname() {
        return this.nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public  int getCost(){
        return this.salary;
    }

    @Override
    public String toString() {
        return "[nameSurname=" + nameSurname + ", salary=" + salary + "]";
    }

    

}
