/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop1;


import com.mycompany.oop1.classes.EmployeeComposite;

/**
 *
 * @author mean
 */
public class Deneme {
  public static void main(String[] args) {

    /*
     * Employee director1 = new Director("Mehmet Akduman", 15000); Employee
     * director2 = new Director("Mehmet Akduman2", 25000); Employee director3 = new
     * Director("Mehmet Akduman3", 35000);
     * 
     * Employee director4 = new Director("Mehmet Akduman4", 45000);
     * 
     * director1.add(director4);
     * 
     * director1.add(new Officer("nameSurname", 1000)); director1.add(new
     * Officer("nameSurname2", 1500)); director1.add(director3);
     * 
     * director3.add(new Officer("nameSurname4", 1250)); director3.add(new
     * Officer("nameSurname5", 1300));
     * 
     * director1.add(director2);
     * 
     * director2.add(new Officer("nameSurname6", 1250)); director2.add(new
     * Officer("nameSurname7", 1300));
     * 
     * EmployeeComposite employeeComposite = new EmployeeComposite(director1);
     * employeeComposite.getEmployeeList();
     */
    
    EmployeeComposite emp = EmployeeComposite.processTxtFile();

    emp.getEmployeeList();
  }
}
