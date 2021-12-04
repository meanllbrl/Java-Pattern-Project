package com.mycompany.oop1.classes;

import java.util.List;

public class Director extends Employee{
    private List<Employee> employee;

    public Director(String nameSurname, int salary,List<Employee> employee) {
        super(nameSurname,salary);
        this.employee = employee;
    }

    public List<Employee> getEmployee() {
        return this.employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public int getCost(){
        int _total = 0;
        for (Employee element : employee) {
            _total += element.getCost();
        }
        _total += super.getSalary();
        return _total;
    }

    @Override
    public String toString() {
        return "Director [employee=" + employee + "]";
    }


}
