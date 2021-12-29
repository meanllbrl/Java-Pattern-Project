package com.mycompany.oop1.classes;

import java.util.ArrayList;
import java.util.List;

public class Director extends Employee {
    private ArrayList<Employee> employees = new ArrayList<Employee>();;

    public Director(String nameSurname, int salary) {
        super(nameSurname, salary);
    }

    public List<Employee> getEmployee() {
        return employees;
    }

    public int getCost() {
        int _total = 0;
        // * altında çalışan işcilerin maaşlarının toplamı alınıyor
        for (Employee element : employees) {
            _total += element.getCost();
        }
        // * işcilerin maaşlarının toplamına kendi maaşı da ekleniyor.
        _total += super.getCost();
        return _total;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employee.remove(employee);
    }

    public Employee getEmployee(int employeeIndex) {
        return employees.get(employeeIndex);
    }

    public ArrayList<Employee> getChildren() {
        return employees;
    }

    public boolean contains(Employee emp) {
        for (Employee employee : employees) {
            if (employee.getNameSurname().trim().equalsIgnoreCase(emp.getNameSurname().trim())) {
                return true;
            }
        }
        return false;
    }

    private void recursiveMetod(ArrayList<Employee> list, int depth, boolean isCost) {

        for (Employee element : list) {
            for (int i = 0; i < depth; i++) {
                System.out.print("\t");
            }
            System.out.print("D " + element.getNameSurname() + " "
                    + ((isCost && element.getClass() == Director.class) ? element.getCost() : element.getSalary()) + "\n");
            if (element.getClass() == Director.class) {
                Director el2 = (Director) element;
                if (el2.getChildren().size() > 0) {

                    recursiveMetod(el2.getChildren(), depth + 1, isCost);
                }
            }
        }
    }

    public void displayEmployeeInfo(boolean isCost) {
        int depth = 1;

        System.out.println(isCost ? "\nToplam maaşlar\n" : "\nHam maaşlar\n");

        System.out.println("D " + getNameSurname() + " " + (isCost ? getCost() : getSalary()));
        recursiveMetod(employees, depth,isCost);

        /*
         * System.out.println("D " + getNameSurname() + " " + getCost());
         * 
         * Iterator directorIterator = employees.iterator(); int depth = 0;
         * 
         * while (directorIterator.hasNext()) {
         * 
         * Employee employeeInfo = (Employee) directorIterator.next();
         * System.out.print("\t"); employeeInfo.displayEmployeeInfo();
         * 
         * }
         */
    }
/*
    @Override
    public String toString() {
        Iterator directorIterator = employees.iterator();
        while (directorIterator.hasNext()) {
            Employee employeeInfo = (Employee) directorIterator.next();
            employeeInfo.displayEmployeeInfo();
        }
        return "Director [employee=" + employees + "]";
    }*/

}
