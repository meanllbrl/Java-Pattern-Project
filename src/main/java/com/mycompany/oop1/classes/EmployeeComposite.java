package com.mycompany.oop1.classes;

public class EmployeeComposite {
    Employee employeeList;

    public EmployeeComposite(Employee newEmployeeList) {
        employeeList = newEmployeeList;
    }
    public void getEmployeeList() {
        employeeList.displayEmployeeInfo();
    }
}
