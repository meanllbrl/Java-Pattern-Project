package com.mycompany.oop1.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Director extends Employee {
    private ArrayList<Employee> employees = new ArrayList<Employee>();;
    private String nameSurname;
    private int salary;

    private static int depth2 = 0;

    public Director(String nameSurname, int salary) {
        super(nameSurname, salary);
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
        return employees.get(employeeIndex);
    }

    public ArrayList<Employee> getChildren() {
        return employees;
    }

    private void recursiveMetod(ArrayList<Employee> list, int depth) {
        for (Employee element : list) {
            for (int i = 0; i < depth; i++) {
                System.out.print("\t");
            }
            System.out.print(element.getNameSurname() + "\n");
            if (element.getClass() == Director.class) {
                Director el2 = (Director) element;
                if (el2.getChildren().size() > 0) {

                    recursiveMetod(el2.getChildren(), depth+1);
                }
            }
        }
    }

    public void displayEmployeeInfo() {
        int depth = 1;
        System.out.println("D " + getNameSurname() + " " + getCost());
        recursiveMetod(employees, depth);

        /*
         * System.out.println("D " + getNameSurname() + " " + getCost());
         * 
         * Iterator directorIterator = employees.iterator();
         * int depth = 0;
         * 
         * while (directorIterator.hasNext()) {
         * 
         * Employee employeeInfo = (Employee) directorIterator.next();
         * System.out.print("\t");
         * employeeInfo.displayEmployeeInfo();
         * 
         * }
         */
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

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getNameSurname() {
        return super.getNameSurname();
    }

}
