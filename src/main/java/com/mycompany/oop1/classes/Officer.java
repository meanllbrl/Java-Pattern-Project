package com.mycompany.oop1.classes;

public class Officer extends Employee {

    public Officer(String nameSurname, int salary) {
        super(nameSurname,salary);
    }
    
    
    public int getCost(){
        return super.getCost();
    }


    @Override
    public String toString() {
        return "Officer [ " + super.toString() + "]";
    }
    
}
