package com.sparta.room3;

import com.sparta.room3.model.Exceptions.InvalidDataException;
import com.sparta.room3.model.*;
import org.junit.jupiter.api.*;

public class EmployeeFactoryChecks {
    static private String[] genericSampleData;
    static private Employee genericTestEmployee;
    @BeforeAll
    static void gimmeSomeSampleDataPlz(){
        genericSampleData = new String[] {
            "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294",
                    "178566,Mrs.,Juliette,M,Rojo,F,juliette.rojo@yahoo.co.uk,05/08/1967,06/04/2011,193912",
                    "647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681",
                    "847634,Mr.,Elmer,R,Jason,M,elmer.jason@yahoo.com,04/09/1996,5/28/2017,93504",
                    "260736,Ms.,Zelda,P,Forest,F,zelda.forest@ibm.com,11/27/1959,1/28/2014,176642",
                    "811306,Mr.,Rhett,P,Wan,M,rhett.wan@hotmail.com,7/14/1976,1/21/2009,59406"
        };
        try {
            genericTestEmployee = new Employee("198429,Mrs.,Serafina,I,Bumgarner,F," +
                    "serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /*
    TEST CASES STILL TO BE WRITTEN:

    Empty check for Employee
    Empty check for Employee List
    Null check for Employee List
    Test for graceful handling of getEmployees method with over 1000 points of data
    Check compareTo method for null data handling
    Check firstName data is entered as expected

     */
    @Test/*TEST FOR Phase 1 - 3 / Use Case 1*/
    @DisplayName("Check data is being loaded from the csv and stored in a String array")
    void checkThatDataIsBeingLoadedFromTheCsvAndStoredInAStringArray() {
        try {
            Assertions.assertInstanceOf(String[].class, EmployeeFactory.getEmployees(1));
        }catch(Exception e){
            Assertions.fail();
        }
    }

    @Test/*TEST FOR Phase 1 - 3 / Use Case 1*/
    @DisplayName("Test that IllegalArgumentException is thrown when numEmployees is less than 1")
    void testGetEmployeesIllegalArgumentException() {
        var message = Assertions.assertThrows(IllegalArgumentException.class, ()->EmployeeFactory.getEmployees(0), "Exception expected, got none");
        Assertions.assertEquals("Argument 'numEmployees' must be between 1 and 1000", message.getMessage());
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case 1*/
    @DisplayName("Adding a null employee should throw an exception")
    public void testAddNullEmployee() throws InvalidDataException {//can you create a class file "InvalidDataException.java" in the com.sparta.room3.model package?
    
        EmployeeList list = new EmployeeList(genericSampleData);
        var message = Assertions.assertThrows(NullPointerException.class, ()-> list.addEmployee(null), "Expected exception, threw none");
        Assertions.assertEquals("Null Pointer Exception. Please enter valid data.", message.getMessage());
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case 1*/
    @DisplayName("Check that employee constructor creates an employee object")
    void checkEmployeeConstructor() {
        try {
            Assertions.assertInstanceOf(Employee.class, new Employee("198429,Mrs.,Serafina,I,Bumgarner,F," +
                    "serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294"));
        } catch(Exception e){
            Assertions.fail();
        }
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Check that the  employee constructor's String argument adheres to the correct format: " +
            "--> A sequence of concatenated strings each seperated by 9 commas")
    void checkEmployeeConstructorStringFormat(){
        String illegalFormat = "this,is an,incorrect random sequence, of data to test";

        var message = Assertions.assertThrows(InvalidDataException.class, ()->new Employee(illegalFormat), "Expected exception, got none");
        Assertions.assertEquals("Invalid data detected, missing value", message.getMessage());
        //Employee toTest = new Employee(illegalFormat);
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Test that constructor for EmployeeList successfully creates a list of employee objects")
    void testThatConstructorForEmployeeListSuccessfullyCreatesAListOfEmployeeObjects() throws InvalidDataException{

        EmployeeList employeeList = new EmployeeList(genericSampleData);
        Employee[] employees = employeeList.getEmployees();
        Employee firstInReturnedList = employees[0];
        Employee lastInReturnedList = employees[employees.length - 1];

        Assertions.assertEquals(new Employee("198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com," +
                "9/21/1982,02/01/2008,69294").compareTo(firstInReturnedList), 0);
        Assertions.assertEquals(new Employee("811306,Mr.,Rhett,P,Wan,M,rhett.wan@hotmail.com,7/14/1976,1/21/2009,59406")
                .compareTo(lastInReturnedList), 0);
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Test that an employee object properly parses and stores the first name property")
    void testThatAnEmployeeProperlyParsesAndStoresTheFirstNameProperty() throws InvalidDataException {
        Employee employee = new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681");
        Assertions.assertEquals("Milan", employee.getFirstName());
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Test that an employee object properly parses and stores the last name property")
    void testThatAnEmployeeProperlyParsesAndStoresTheLastNameProperty()throws InvalidDataException{
        Employee employee = new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681");
        Assertions.assertEquals("Krawczyk", employee.getLastName());
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Test that an employee object properly parses and stores the employee number property")
    void testThatAnEmployeeProperlyParsesAndStoresTheEmployeeNumberProperty()throws InvalidDataException{
        Employee employee = new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681");
        Assertions.assertEquals(Integer.parseInt("647173"), employee.getEmployeeNumber());
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Test that an employee object properly parses and stores the birthday date property")
    void testThatAnEmployeeProperlyParsesAndStoresTheEmployeeDateOfBirth()throws InvalidDataException{
        Employee employee = new Employee("198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294");
        Assertions.assertEquals("9/21/1982",employee.getBirthDate());
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Test that an employee object properly parses and stores the hire date property")
    void testThatAnEmployeeProperlyParsesAndStoresTheHireDateProperty()throws InvalidDataException{
        Employee employee = new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681");
        Assertions.assertEquals("1/19/2012", employee.getHireDate());
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Test that an employee object properly parses and stores the gender property")
    void testThatAnEmployeeProperlyParsesAndStoresTheGenderProperty()throws InvalidDataException{
        Employee employee = new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681");
        Assertions.assertEquals("M", employee.getGender());
    }
    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Test that when we are given a blank first name that an exception gets thrown for invalid data")
    void testThatWhenWeAreGivenABlankFirstNameFromCSVExceptionGetsThrownInvalidData(){
        var message = Assertions.assertThrows(InvalidDataException.class, ()->new Employee("198429,Mrs.,,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294"), "Everything worked fine!");
        Assertions.assertEquals("Invalid data detected, missing value", message.getMessage());
        /*STILL FAILS*/
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Test that when we are given a blank last name that an exception gets thrown for invalid data")
    void testThatWhenWeAreGivenABlankLastNameFromCSVExceptionGetsThrownInvalidData(){
        var message = Assertions.assertThrows(InvalidDataException.class, ()->new Employee("198429,Mrs.,Serafina,I,,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294"), "Everything worked fine!");
        Assertions.assertEquals("Invalid data detected, missing value", message.getMessage());
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Test that when we are given a blank employee number that an exception gets thrown for invalid data")
    void testThatWhenWeAreGivenABlankEmployeeNumberFromCSVExceptionGetsThrownInvalidData(){
        var message = Assertions.assertThrows(InvalidDataException.class, ()->new Employee(",Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294"), "Everything worked fine!");
        Assertions.assertEquals("Invalid data detected, missing value", message.getMessage());
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Test that when we are given a blank gender an exception gets thrown for invalid data")
    void testThatWhenWeAreGivenABlankGenderFromCSVExceptionGetsThrownInvalidData(){
        var message = Assertions.assertThrows(InvalidDataException.class, ()->new Employee("198429,Mrs.,Serafina,I,Bumgarner,,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294"), "Everything worked fine!");
        Assertions.assertEquals("Invalid data detected, missing value", message.getMessage());
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Test that when we are given a blank birth date an exception gets thrown for invalid data")
    void testThatWhenWeAreGivenABlankBirthDateFromCSVExceptionGetsThrownInvalidData(){
        var message = Assertions.assertThrows(InvalidDataException.class, ()->new Employee("198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,,02/01/2008,69294"), "Everything worked fine!");
        Assertions.assertEquals("Invalid data detected, missing value", message.getMessage());
    }

    @Test /*TEST FOR Phase 1 - 4 / Use Case Undefined*/
    @DisplayName("Test that when we are given a blank hire date an exception gets thrown for invalid data")
    void testThatWhenWeAreGivenABlankHireDateFromCSVExceptionGetsThrownInvalidData(){
        var message = Assertions.assertThrows(InvalidDataException.class, ()->new Employee("198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,,69294"), "Everything worked fine!");
        Assertions.assertEquals("Invalid data detected, missing value", message.getMessage());
    }
    @Test /*TEST FOR Phase 3 - Undefined / Use Case Undefined*/
    @DisplayName("Tests the toString method of the employee class, to ensure a string is returned")
    void checkEmployeeToStringMethodReturnsAString(){
        Assertions.assertInstanceOf(String.class, genericTestEmployee.toString());
    }

    @Test /*TEST FOR Phase 3 - Undefined / Use Case Undefined*/
    @DisplayName("Checks the toString method returns the correct content")
    void checkEmployeeToStringMethodReturnsCorrectContent(){
        String correctContent = genericTestEmployee.getEmployeeNumber()+", "+ genericTestEmployee.getBirthDate()+", "+ genericTestEmployee.getFirstName()+
                ", "+ genericTestEmployee.getLastName()+", "+ genericTestEmployee.getGender()+", "+ genericTestEmployee.getHireDate();

        Assertions.assertEquals(correctContent, genericTestEmployee.toString());
    }

    @Test /*TEST FOR Phase 3 - 1 / Use Case Undefined*/
    @DisplayName("Test that the add method of the EmployeeList class inserts an employee")
    void checkThatTheAddMethodOfTheEmployeeListInsertsAnEmployee()throws InvalidDataException{
        EmployeeList list = new EmployeeList(genericSampleData);
        list.addEmployee(new Employee("8675309,Mrs.,Jane,I,Doe,F,serafina.bumgarner@somewhere.com,9/21/1982,02/01/2008,69294"));
        Employee latestInsert = list.getEmployee(genericSampleData.length);
        Employee newlyCreatedEmployee = new Employee("8675309,Mrs.,Jane,I,Doe,F,serafina.bumgarner@somewhere.com,9/21/1982,02/01/2008,69294");
        Assertions.assertTrue(newlyCreatedEmployee.compareTo(latestInsert) == 0);
    }
    @Test /*TEST FOR Phase 3 - 3 / Use Case Undefined*/
    @DisplayName("Ensure that the compareTo method compares employees by last name and then by first name")
    void checkThatTheCompareToMethodOfTheEmployeeClassComparesEmployeesByLastNameFirstAndThenByFirstName() throws InvalidDataException{
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

    @Test /*TEST FOR Phase 3 - 3 / Use Case Undefined*/
    @DisplayName("Check That The getEmployee Method Of The employeeList Gets The Correct Employee")
    void checkThatTheGetEmployeeMethodOfTheEmployeeListGetsTheCorrectEmployee()throws InvalidDataException{
        EmployeeList list = new EmployeeList(genericSampleData);
        Assertions.assertEquals(list.getEmployee(2).getEmployeeNumber(), Integer.parseInt("647173"));
    }
}