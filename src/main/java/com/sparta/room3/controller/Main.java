package com.sparta.room3.controller;



import com.sparta.room3.model.*;
import com.sparta.room3.model.Exceptions.InvalidDataException;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InvalidDataException {
        // Generate an array of random employee data of size n
        int n = 10; // Example value, can be changed
        String[] employeeData = {"198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                "178566,Mrs.,Juliette,M,Rojo,F,juliette.rojo@yahoo.co.uk,05/08/1967,06/04/2011,193912",
                "647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681",
                "847634,Mr.,Elmer,R,Jason,M,elmer.jason@yahoo.com,04/09/1996,5/28/2017,93504",
                "260736,Ms.,Zelda,P,Forest,F,zelda.forest@ibm.com,11/27/1959,1/28/2014,176642",
                "811306,Mr.,Rhett,P,Wan,M,rhett.wan@hotmail.com,7/14/1976,1/21/2009,59406",
                "260736,Ms.,Zelda,P,Forest,F,zelda.forest@ibm.com,11/27/1959,1/28/2014,176642"};//EmployeeFactory.getEmployees(n);
        EmployeeList employeees = new EmployeeList(employeeData);
        List<Employee> employeeList = List.of(employeees.getEmployees());

        BinarySearchTree<Employee> baseTree = new BinarySearchTree<>(employeeList);
        EmployeeTreeDecorator tree = new EmployeeTreeDecorator(baseTree);
        for(Employee o : tree.getSortedTreeDesc())
            System.out.println(o);

        System.out.println("Count: " + tree.getNumberOfElements());

        System.out.println("Find element \"Jason\" result:\n" + tree.findElement("Jason"));
        System.out.println("Find elements \"Forest\" result: ");
        Employee[] results = tree.findElements("Forest");
        for(Employee o : results){
            System.out.println(o);
        }
        System.out.println(tree.getRootElement());
    }
}