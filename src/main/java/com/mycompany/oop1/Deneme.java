/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop1;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.oop1.classes.Director;
import com.mycompany.oop1.classes.Employee;
import com.mycompany.oop1.classes.Officer;

/**
 *
 * @author mean
 */
public class Deneme {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(
          new  Officer("name",34)
        );employees.add(
          new  Officer("name",34)
        );employees.add(
          new  Officer("name",34)
        );
        Director employee = new Director("nameSurname", 50, employees);

       System.out.println(employee.toString()); 
    }
}
