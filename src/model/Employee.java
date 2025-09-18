package model;

public class Employee {
    
    //declaring fields for Employee class
    private int id;
    private String name;
    private String department;
    private double salary;

    //constructor to initialize Employee object which takes id, name, department and salary as parameters
    public Employee(int id, String name, String department, double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    //generating getters and setters for all fields
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDepartment(){
        return department;
    }

    public Double getSalary(){
        return salary;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    //toString method to print Employee object details in a readable format
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
    }

}
