package com.sparta.group3;



import com.sparta.group3.controller.Controller;
import com.sparta.group3.model.*;
import com.sparta.group3.model.Exceptions.InvalidDataException;
import com.sparta.group3.view.CLI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        try {
            int n = 8;
            String[] employeeData = EmployeeFactory.getEmployees(n);
            EmployeeList employees = new EmployeeList(employeeData);
            List<Employee> employeeList = List.of(employees.getEmployees());
            BinarySearchTree<Employee> baseTree = new BinarySearchTree<Employee>(employeeList);
            EmployeeTreeDecorator tree = new EmployeeTreeDecorator(baseTree);
            Controller controller = new Controller(tree);
            CLI cli = new CLI(controller);
        } catch(IOException e){
            if(!(e instanceof FileNotFoundException))
                logger.fatal("There was an error reading the file: 'employees.csv'");
            logger.fatal(e.getMessage());
        }finally{
            logger.info("Exiting...");
            System.out.println("Exiting...");
            System.exit(0);
        }
    }
}