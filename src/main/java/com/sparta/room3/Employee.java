package com.sparta.room3;

public class Employee {
    private final String emp_no;
    private final String birth_date;
    private final String first_name;
    private final String last_name;
    private final String gender;
    private final String hire_date;

    public Employee(String employeeData) {
        String[] data = employeeData.split(",");
        emp_no = data[0];
        birth_date = data[7];
        first_name = data[2];
        last_name = data[4];
        gender = data[5];
        hire_date = data[8];
    }

    public String getEmp_no() {
        return emp_no;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public String getHire_date() {
        return hire_date;
    }

    @Override
    public String toString() {
        return emp_no + ", " + birth_date + ", " + first_name + ", " + last_name + ", " + gender + ", " + hire_date ;
    }
}