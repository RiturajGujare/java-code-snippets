package model;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


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

        //snippet to filter employees by department
        Scanner sc = new Scanner(System.in);   //Scanner object to take user input
        System.out.println("Enter the department whose employee are to be fetched: ");
        String findDepartment = sc.nextLine(); //taking department name as input from user

        List<Employee> employeeByDepartment = employees.stream()    //creating stream of Employee objects
                                                .filter(employee -> employee.getDepartment().equals(findDepartment))  //filtering employees based on department
                                                .collect(Collectors.toList()); //collecting filtered employees into a list
        
        System.out.println(findDepartment + " Department contains below employees: ");
        for(Employee emp: employeeByDepartment){   //iterating through the list of employees in the specified department
            System.out.println("Employee name: " + emp.getName() + " works in " + emp.getDepartment() + " department"); //printing employee name and department
        }



        sc.close(); //closing the scanner object to prevent resource leak
    }
}
