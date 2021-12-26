package com.mycompany.oop1.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Director extends Employee {
    private ArrayList<Employee> employees = new ArrayList<Employee>();;
    private String nameSurname;
    private int salary;

    public Director(String nameSurname, int salary) {
        this.nameSurname = nameSurname;
        this.salary = salary;
    }

    public String getDirectorName() {
        return nameSurname;
    }

    public int getSalary() {
        return salary;
    }

    public List<Employee> getEmployee() {
        return this.employees;
    }

    public int getCost() {
        int _total = 0;
        // * altında çalışan işcilerin maaşlarının toplamı alınıyor
        for (Employee element : employees) {
            _total += element.getCost();
        }
        // * işcilerin maaşlarının toplamına kendi maaşı da ekleniyor.
        _total += salary;
        return _total;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employee.remove(employee);
    }

    public Employee getEmployee(int employeeIndex) {
        return (Employee) employees.get(employeeIndex);
    }

    public void displayEmployeeInfo() {
       
        System.out.println("D " + getDirectorName() + " " + getCost());
    
        Iterator directorIterator = employees.iterator();
        while (directorIterator.hasNext()) {
            Employee employeeInfo = (Employee) directorIterator.next();
            employeeInfo.displayEmployeeInfo();
        }

    }

    @Override
    public String toString() {
        Iterator directorIterator = employees.iterator();
        while (directorIterator.hasNext()) {
            Employee employeeInfo = (Employee) directorIterator.next();
            employeeInfo.displayEmployeeInfo();
        }
        return "Director [employee=" + employees + "]";
    }

}
