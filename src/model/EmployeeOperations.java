package model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
        System.out.println("-----------------------------------");
        System.out.println("--------------------------------");

        //Filtering employees who earn more than the average salary
        //Using Stream API to filter employees based on their salary compared to the average salary
        List<Employee> employeeEarningMoreThanAverage = employees.stream()
                                                        .filter((employee -> employee.getSalary() > averageSalary)) //filtering employees whose salary is greater than average salary   
                                                        .collect(Collectors.toList());
        
        System.out.println("Employees earning more than average are");
        for(Employee employee: employeeEarningMoreThanAverage){
            //iterating through the list of employees earning more than average and printing their name and salary
            //Using getName() and getSalary() methods of Employee class to fetch employee details
            System.out.println("Name of Employee: " + employee.getName() + " and his salary is: " + employee.getSalary());
        }

        System.out.println("-----------------------------------");
        System.out.println("--------------------------------");
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

        System.out.println("-----------------------------------");
        System.out.println("--------------------------------");

        //Sorting employees based on their salary in ascending order using Stream API
        List<Employee> salaryBasedSortedEmployee = employees.stream()  //creating stream of Employee objects
                                                    .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))  //sorting employees based on salary using comparator
                                                    .collect(Collectors.toList());
        
        //printing the sorted list of employees based on salary
        System.out.println("Employee list based on salary");

        //iterating through the sorted list and printing employee name and salary
        for(Employee employee: salaryBasedSortedEmployee){
            System.out.println("Name of employee: " + employee.getName() + " and employee salary: " + employee.getSalary());
        }
                                                    

        System.out.println("-----------------------------------");
        System.out.println("--------------------------------");
        //Grouping employees based on their department using Stream API
        Map<String, List<Employee>> groupedEmployee = employees.stream()  //creating stream of Employee objects
                                                        .collect(Collectors.groupingBy(
                                                            Employee::getDepartment  //grouping by department
                                                        ));
        
        //printing the grouped employees based on department
        groupedEmployee.forEach((dept, empList) -> {   //iterating through the map of department and list of employees
            System.out.println("Department: " + dept); //printing department name
            System.out.println("Employees working in " + dept + " department"); //printing employees in that department
            for(Employee employee: empList){
                System.out.println(employee.getName()); //printing employee name
            }
        });


        System.out.println("-----------------------------------");
        System.out.println("--------------------------------");

        //example to find the employee with the highest salary using Stream API
        //Using sorted() method to sort employees based on salary in descending order and then finding the first employee in the sorted list
        //Also using max() method with Comparator to find the employee with the highest salary
        Employee employee = employees.stream()
                            //sorting employees based on salary in descending order, e2.getSalary() is compared with e1.getSalary() because we want the highest salary first
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())) 
                            .findFirst()
                            .orElse(null);
        System.out.println("Highest salaried employee is: " + employee.getName() + " and his salary is: " + employee.getSalary());

        //Using max() method with Comparator to find the employee with the highest salary
        //comparing employee salary using comparingDouble method of Comparator
        Employee employee2 = employees.stream()
                            .max(Comparator.comparingDouble(Employee::getSalary))
                            .orElse(null);
        System.out.println("Highest salaried employee calculated using comparingDouble method is: " + employee2.getName() + " and his salary is: " + employee2.getSalary());

        System.out.println("-----------------------------------");
        System.out.println("--------------------------------");

        sc.close(); //closing the scanner object to prevent resource leak
    }
}
