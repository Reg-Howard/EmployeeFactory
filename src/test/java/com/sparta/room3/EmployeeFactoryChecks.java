package com.sparta.room3;

import com.sparta.room3.model.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Arrays;

public class EmployeeFactoryChecks {
    /*NEED TO ADD NULL AND EMPTY CHECKS FOR EMPLOYEE AND EMPLOYEELIST*/
    @Test/*TEST FOR P2 / Phase 1 - 3 / Use Case 1*/
    @DisplayName("Check data is being loaded from the csv and stored in a String array")
    void checkThatDataIsBeingLoadedFromTheCsvAndStoredInAStringArray() {
        try {
            Assertions.assertInstanceOf(String[].class, EmployeeFactory.getEmployees(1));
        }catch(Exception e){
            Assertions.fail();
        }
    }
    @Test
    @DisplayName("Check that employee constructor creates an employee object")
    void checkEmployeeConstructor(){
        Assertions.assertInstanceOf(Employee.class, new Employee("198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294"));
    }


    //NOT COMPLETE YET COME BACK TO IT LATER ON!!!
    /*@Test
    @DisplayName("Check constructor throws exception if illegal string format/length " +
            "is used in the constructor")
    void checkConstructorIllegalStringInput(){
        var message = Assertions.assertThrows(Exception.class, ()-> new Employee("500000000000000000") , "Invalid String Parameter!");
        Assertions.assertEquals(message.getMessage(),"To be Completed!");
    }*/



    @Test /*WE NEED TO MAKE SURE THAT THIS IS HOW THEY WANT THIS DONE*/
    @DisplayName("Ensure that the compareTo method compares employees by last name and then by first name")
    void checkThatTheCompareToMethodOfTheEmployeeClassComparesEmployeesByLastNameFirstAndThenByFirstName(){
        Employee employeeOne = new Employee("198429,Mrs.,A,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294");
        Employee employeeTwo = new Employee("198429,Mrs.,B,I,B,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294");
        Employee employeeThree = new Employee("198429,Mrs.,A,I,B,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294");
        Employee employeeFour = new Employee("198429,Mrs.,B,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294");
        Employee employeeFive = new Employee("198429,Mrs.,A,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294");
        Assertions.assertTrue(employeeOne.compareTo(employeeTwo) < 0);
        Assertions.assertTrue(employeeFive.compareTo(employeeOne) == 0);
        Assertions.assertTrue(employeeTwo.compareTo(employeeThree) > 0);
        Assertions.assertTrue(employeeFour.compareTo(employeeOne) > 0);
    }

    @Test
    @DisplayName("Test that constructor for EmployeeList successfully creates a list of employee objects")
    void testThatConstructorForEmployeeListSuccessfullyCreatesAListOfEmployeeObjects(){
        String[] sampleData = {
                "198429,Mrs.,A,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                "198429,Mrs.,B,I,B,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                "198429,Mrs.,A,I,B,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                "198429,Mrs.,B,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                "198429,Mrs.,A,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294"
        };
        EmployeeList employeeList = new EmployeeList(sampleData);
        Employee[] employees = employeeList.getEmployees();
        Employee firstInReturnedList = employees[0];
        Employee lastInReturnedList = employees[employees.length - 1];
        Assertions.assertTrue(new Employee("198429,Mrs.,A,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294").compareTo(firstInReturnedList) == 0);
        Assertions.assertTrue(new Employee("198429,Mrs.,A,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294").compareTo(lastInReturnedList) == 0);
        System.out.println(employeeList.toString());
    }

    //"//employeeNumber + ", " + birthDate + ", " + firstName + ", " + lastName + ", " + gender + ", " + hireDate ;
    @Test
    @DisplayName("Test that an employee object properly parses and stores the first name property")
    void testThatAnEmployeeProperlyParsesAndStoresTheFirstNameProperty(){
        Employee employee = new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681");
        Assertions.assertEquals("Milan", employee.getFirstName());
    }

    @Test
    @DisplayName("Test that an employee object properly parses and stores the last name property")
    void testThatAnEmployeeProperlyParsesAndStoresTheLastNameProperty(){
        Employee employee = new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681");
        Assertions.assertEquals("Milan", employee.getFirstName());
    }

    @Test
    @DisplayName("Test that an employee object properly parses and stores the employee number property")
    void testThatAnEmployeeProperlyParsesAndStoresTheEmployeeNumberProperty(){
        Employee employee = new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681");
        Assertions.assertEquals(Integer.parseInt("647173"), employee.getEmployeeNumber());
    }
    @Test
    @DisplayName("Check Employee Birth Date is returned by calling the Getter method")
    void checkEmployeeBirthDateGetterReturn(){
        Employee e = new Employee("198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294");
        Assertions.assertEquals("9/21/1982",e.getBirthDate());
    }
    @Test
    @DisplayName("Test that an employee object properly parses and stores the hire date property")
    void testThatAnEmployeeProperlyParsesAndStoresTheHireDateProperty(){
        Employee employee = new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681");
        Assertions.assertEquals("1/19/2012", employee.getHireDate());
    }
    @Test
    @DisplayName("Test that an employee object properly parses and stores the gender property")
    void testThatAnEmployeeProperlyParsesAndStoresTheGenderProperty(){
        Employee employee = new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681");
        Assertions.assertEquals("M", employee.getGender());
    }

    @Test
    @DisplayName("Test that the add method of the EmployeeList class inserts an employee")
    void checkThatTheGetEmployeeMethodOfTheEmployeeListGetsTheCorrectEmployee(){
        String[] sampleData = {
                "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
        "178566,Mrs.,Juliette,M,Rojo,F,juliette.rojo@yahoo.co.uk,05/08/1967,06/04/2011,193912",
        "647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681",
        "847634,Mr.,Elmer,R,Jason,M,elmer.jason@yahoo.com,04/09/1996,5/28/2017,93504",
        "260736,Ms.,Zelda,P,Forest,F,zelda.forest@ibm.com,11/27/1959,1/28/2014,176642",
        "811306,Mr.,Rhett,P,Wan,M,rhett.wan@hotmail.com,7/14/1976,1/21/2009,59406"
        };
        EmployeeList list = new EmployeeList(sampleData);
        Assertions.assertEquals(list.getEmployee(2).getEmployeeNumber(), Integer.parseInt("647173"));
    }

    @Test
    @DisplayName("Test that the add method of the EmployeeList class inserts an employee")
    void checkThatTheAddMethodOfTheEmployeeListInsertsAnEmployee(){
        String[] sampleData = {
                "198429,Mrs.,A,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                "198429,Mrs.,B,I,B,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                "198429,Mrs.,A,I,B,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                "198429,Mrs.,B,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                "198429,Mrs.,A,I,A,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294"
        };
        EmployeeList list = new EmployeeList(sampleData);
        list.addEmployee(new Employee("8675309,Mrs.,Jane,I,Doe,F,serafina.bumgarner@somewhere.com,9/21/1982,02/01/2008,69294"));
        Employee latestInsert = list.getEmployee(sampleData.length);
        Employee newlyCreatedEmployee = new Employee("8675309,Mrs.,Jane,I,Doe,F,serafina.bumgarner@somewhere.com,9/21/1982,02/01/2008,69294");
        Assertions.assertTrue(newlyCreatedEmployee.compareTo(latestInsert) == 0);
    }




}