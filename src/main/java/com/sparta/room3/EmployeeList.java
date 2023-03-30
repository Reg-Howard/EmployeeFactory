package com.sparta.room3;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private final List<Employee> employees;

    public EmployeeList() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void printEmployees() {
        employees.forEach(System.out::println);
    }
}