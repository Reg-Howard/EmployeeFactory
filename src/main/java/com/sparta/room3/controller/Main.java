package com.sparta.room3.controller;



import com.sparta.room3.model.Employee;
import com.sparta.room3.model.EmployeeFactory;
import com.sparta.room3.model.EmployeeList;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        // Generate an array of random employee data of size n
        int n = 10; // Example value, can be changed
        String[] employeeData = EmployeeFactory.getEmployees(n);

        // Convert each element in the array into an Employee object and store in a list
        EmployeeList employeeList = new EmployeeList(employeeData);
        String[] sampleData = {
                "198429,Mrs.,A,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                "198429,Mrs.,B,I,B,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                "198429,Mrs.,A,I,B,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                "198429,Mrs.,B,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                "198429,Mrs.,A,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294"
        };
        EmployeeList employeeList1 = new EmployeeList(sampleData);
        System.out.println(Arrays.deepToString(employeeList.getEmployees()));
        System.out.println(employeeList.toString());
        System.out.println();
        /*Arrays.stream(employeeData)
                .map(Employee::new)
                .forEach(employeeList::addEmployee);*/


        // Print the list of employees
        employeeList.printEmployees();
    }
}