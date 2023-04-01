package com.sparta.room3.controller;



import com.sparta.room3.model.BinarySearchTree;
import com.sparta.room3.model.Employee;
import com.sparta.room3.model.EmployeeFactory;
import com.sparta.room3.model.EmployeeList;
import com.sparta.room3.model.Exceptions.InvalidDataException;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InvalidDataException {
        // Generate an array of random employee data of size n
        int n = 10; // Example value, can be changed
        String[] employeeData = EmployeeFactory.getEmployees(n);
        EmployeeList employeees = new EmployeeList(employeeData);
        List<Employee> employeeList = List.of(employeees.getEmployees());

        BinarySearchTree<Employee> tree = new BinarySearchTree<>(employeeList);
        for(Object o : tree.getSortedTreeDesc())
            System.out.println(o);
        System.out.println("Count: " + tree.getNumberOfElements());
    }
}