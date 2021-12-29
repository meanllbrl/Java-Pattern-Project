/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.oop1.classes.Director;
import com.mycompany.oop1.classes.Employee;
import com.mycompany.oop1.classes.EmployeeComposite;
import com.mycompany.oop1.classes.Officer;

/**
 *
 * @author mean
 */
public class oop1test {

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void displayEmployee() {
        Employee employee = new Officer("", 80);
        assertNotNull(employee, "Employyeee null dönüyor");
    }

    @Test
    public void calculateSalary() {
        Director director = new Director("Ugur Guclu", 2000);
        director.add(new Officer("Emre Kosar", 700));
        director.add(new Officer("Ahmet Egeli", 700));

        // expected 700 + 700 + 2000 = 3400
        assertEquals(3400, director.getCost(), "Beklenilen maaş fiyatı sağlanamadı.");
    }
}
