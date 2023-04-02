package com.sparta.group3;



import com.sparta.group3.controller.Controller;
import com.sparta.group3.model.*;
import com.sparta.group3.model.Exceptions.InvalidDataException;
import com.sparta.group3.view.CLI;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InvalidDataException {
        int n = 10;
        String[] employeeData = EmployeeFactory.getEmployees(n);
        EmployeeList employees = new EmployeeList(employeeData);
        List<Employee> employeeList = List.of(employees.getEmployees());
        BinarySearchTree<Employee> baseTree = new BinarySearchTree<Employee>(employeeList);
        EmployeeTreeDecorator tree = new EmployeeTreeDecorator(baseTree);
        Controller controller = new Controller(tree);
        CLI cli = new CLI(controller);
    }
}