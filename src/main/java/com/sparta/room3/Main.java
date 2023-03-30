package com.sparta.room3;



import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        // Generate an array of random employee data of size n
        int n = 10; // Example value, can be changed
        String[] employeeData = EmployeeFactory.getEmployees(n);

        // Convert each element in the array into an Employee object and store in a list
        EmployeeList employeeList = new EmployeeList();
        Arrays.stream(employeeData)
                .map(Employee::new)
                .forEach(employeeList::addEmployee);


        // Print the list of employees
        employeeList.printEmployees();
    }
}