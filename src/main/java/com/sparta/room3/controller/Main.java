package com.sparta.room3.controller;



import com.sparta.room3.model.Employee;
import com.sparta.room3.model.EmployeeFactory;
import com.sparta.room3.model.EmployeeList;
import com.sparta.room3.model.InvalidDataException;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, InvalidDataException {
        // Generate an array of random employee data of size n
        int n = 10; // Example value, can be changed
        String[] employeeData = EmployeeFactory.getEmployees(n);

        EmployeeList employeeList = new EmployeeList(employeeData);


        employeeList.printEmployees();
    }
}