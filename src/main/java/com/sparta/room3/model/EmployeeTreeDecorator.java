package com.sparta.room3.model;

import com.sparta.room3.model.Exceptions.InvalidDataException;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTreeDecorator {
    private BinarySearchTree<Employee> tree;
    public EmployeeTreeDecorator(BinarySearchTree<Employee> tree){
        this.tree = tree;
    }

    public Employee getRootElement() {
        return (Employee) tree.getRootElement();
    }


    public int getNumberOfElements() {
        return tree.getNumberOfElements();
    }

    public void addElement(Employee element) {
        tree.addElement(element);
    }

    public void addElements(List<Employee> elements) {
        for(Employee element : elements){
            tree.addElement(element);
        }
    }


    public Employee findElement(String value) {
        try {
            Employee employee = new Employee("178566,Mrs.,Juliette,M," + value + ",F,juliette.rojo@yahoo.co.uk,05/08/1967,06/04/2011,193912");
            return (Employee) tree.findElement(employee);
        }catch(InvalidDataException e){
            e.printStackTrace();
            return null;
        }
    }

    public Employee[] findElements(String searchTarget){
        try {
            Employee employee = new Employee("178566,Mrs.,Juliette,M," + searchTarget + ",F,juliette.rojo@yahoo.co.uk,05/08/1967,06/04/2011,193912");
            Object[] results = tree.findElements(employee);
            if(results != null) {
                Employee[] employees = new Employee[results.length];
                System.arraycopy(results, 0, employees, 0, results.length);
                return employees;
            }
            return new Employee[]{};
        }catch(InvalidDataException e){
            e.printStackTrace();
            return new Employee[]{};
        }
    }


    public Object[] getSortedTreeAsc() {
        Object[] results = tree.getSortedTreeAsc();
        Employee[] employees = new Employee[results.length];
        System.arraycopy(results, 0, employees, 0, results.length);
        return employees;
    }

    public Employee[] getSortedTreeDesc() {
        Object[] results = tree.getSortedTreeDesc();
        Employee[] employees = new Employee[results.length];
        System.arraycopy(results, 0, employees, 0, results.length);
        return employees;
    }

    public Employee getRightChildValue(Employee employee){
        try {
            return tree.getRightChild(employee);
        }catch(Exception e){
            return null;
        }
    }

    public Employee getRightChildValue(String employeeLastName){
        try {
            Employee employee = new Employee("178566,Mrs.,Juliette,M," + employeeLastName + ",F,juliette.rojo@yahoo.co.uk,05/08/1967,06/04/2011,193912");
            return tree.getRightChild(employee);
        }catch(Exception e){
            return null;
        }
    }

    public Employee getLeftChildValue(Employee employee){
        try {
            return tree.getLeftChild(employee);
        }catch(Exception e){
            return null;
        }
    }

    public Employee getLeftChildValue(String employeeLastName){
        try {
            Employee employee = new Employee("178566,Mrs.,Juliette,M," + employeeLastName + ",F,juliette.rojo@yahoo.co.uk,05/08/1967,06/04/2011,193912");
            return tree.getLeftChild(employee);
        }catch(Exception e){
            return null;
        }
    }

}
