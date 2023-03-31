package com.sparta.room3.model;

public class Employee implements Comparable {
    private final int employeeNumber;
    private final String birthDate;
    private final String firstName;
    private final String lastName;
    private final String gender;
    private final String hireDate;

    public Employee(String employeeData) {
        String[] data = employeeData.split(",");
        employeeNumber = Integer.parseInt(data[0]);
        birthDate = data[7];
        firstName = data[2];
        lastName = data[4];
        gender = data[5];
        hireDate = data[8];
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return employeeNumber + ", " + birthDate + ", " + firstName + ", " + lastName + ", " + gender + ", " + hireDate ;
    }

    @Override //compare based off of last name first, and then first name if last names are the same
    public int compareTo(Object o) {
        Employee obj = (Employee) o;
        int value = this.lastName.compareTo(obj.lastName);
        if(value == 0){
            return this.firstName.compareTo(obj.firstName);
        }else{
            return value;
        }
    }
}