package com.sparta.group3.model;

import java.util.*;

import com.sparta.group3.Main;
import com.sparta.group3.model.Exceptions.InvalidDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeeList {
    private static final Logger logger = LogManager.getLogger(EmployeeList.class);
    private final List<Employee> employees;

    public EmployeeList() {
        employees = new ArrayList<Employee>();
    }

    public EmployeeList(String[] employeeData) {
        employees = new ArrayList<>();
        for(String individual : employeeData){
            try {
                Employee employee = new Employee(individual);
                employees.add(employee);
            }catch(InvalidDataException e){
                logger.debug("Could not convert string to Employee:\n \"" + individual + "\"");
            }
        }
    }

    public Employee getEmployee(int i){
        return employees.get(i);
    }

    public Employee[] getEmployees(){
        return employees.toArray(Employee[]::new);
    }

    public void addEmployee(Employee employee) {
        if(employee == null) throw new NullPointerException("Null Pointer Exception. Please enter valid data.");
        employees.add(employee); }

    public void printEmployees() {
        employees.forEach(System.out::println);
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[\n");

        for(int i = 0; i < employees.size(); i++){
            Employee employee = employees.get(i);
            s.append("{\n");
            s.append("\t\"employeeId\":");
            s.append(employee.getEmployeeNumber());
            s.append(",\n");
            s.append("\t\"birthDate\":\"");
            s.append(employee.getBirthDate());
            s.append("\",\n\t");
            s.append("\"firstName\":\"");
            s.append(employee.getFirstName());
            s.append("\",\n\t");
            s.append("\"lastName\":\"");
            s.append(employee.getLastName());
            s.append("\",\n\t");
            s.append("\"gender\":\"");
            s.append(employee.getGender());
            s.append("\",\n\t");
            s.append("\"hireDate\":\"");
            s.append(employee.getHireDate());
            s.append("\"\n");
            s.append("}");
            if(i != employees.size() - 1)
                s.append(",");
            s.append("\n");
        }
        s.append("]");
        return s.toString();
    }
}