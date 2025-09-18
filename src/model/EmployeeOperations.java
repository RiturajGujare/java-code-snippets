package model;

import java.util.Arrays;
import java.util.List;


/*
 * This class demonstrates operations on Employee objects.
 */
public class EmployeeOperations {
    
    public static void main(String[] args) {
        
        //Creating a list of Employee objects
        List<Employee> employees = Arrays.asList(
            new Employee(101, "Rituraj", "IT", 10000),
            new Employee(102, "Anand", "Admin", 15000),
            new Employee(103, "Saurabh", "IT", 20000),
            new Employee(104, "Pradip", "HR", 8000),
            new Employee(105, "Vivek", "Sales", 5000),
            new Employee(106, "Daylu", "HR", 3000)
        );

        //Calculating average salary of all employees using Stream API
        double averageSalary = employees.stream()
                                .mapToDouble(Employee::getSalary)
                                .average()
                                .orElse(0);
        System.out.println("Average salary of employees is: " + averageSalary);
    }
}
