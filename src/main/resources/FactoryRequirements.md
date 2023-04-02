# Employees Projects Week 5 - SOLID/OOP

## General Requirements

All projects:

- Must be run as Scrum projects
- Should be groups or 5 or 6
- Must apply SOLID & OO principles
- Must use the MVC pattern where there is a user interface - ONLY ONCE WE HAVE COVERED THIS AND IT IS APPROPRIATE
- Should use well-known design patterns where appropriate
- Must include comprehensive ```JUnit``` testing or equivalent
- Should begin with the creation of tests, in line with a test-driven development approach
- Must use ```log4j2``` for appropriate runtime logging or equivalent
- Must implement appropriate exception handling
- Must be hosted on GitHub and thoroughly documented, through a README.md file

## Purpose

In addition to the general goals of projects, this project will give trainees an opportunity to:

- Parse data into a suitable data structure
- Use the ```Collections``` framework
- Develop a collection class from scratch
- Create and use a nested class
- Populate a binary tree from unsorted data
- Provide a user interface and searching capability
- Using interfaces

## Requirements

### Phase 1

- *Add the provided factory class, ```EmployeeFactory.java```, to a suitable package within your project*
- *Add the provided sample data file, ```employees.csv```, to the ```src/main/resources``` folder in your project*
- Call ```EmployeeFactory.getEmployees(n)``` to generate an array of random employee data of size ```n``` (```1 <= n <= 1000```)
- Employee data is provided as an array of ```String```s, returned from ```getEmployees()```, each ```String``` representing
  - ```emp_no``` (up to 8 digits)
  - ```birth_date``` (```YYYY-MM-DD```, ```ISO 8601``` calendar date format)
  - ```first_name``` (alpha characters and spaces only)
  - ```last_name``` (alpha characters and spaces only)
  - ```gender``` (single character)
  - ```hire_date``` (```YYYY-MM-DD```)
- The values for the employee data will be separated by commas within the ```String```
  - For example, ```"1234567,1995-01-23,Teagan,Griffith,F,2012-04-12"```
- Convert each element in the array into an ```Employee``` object, having created a suitable class, and store it in a ```List``` using a suitable concrete type



### Phase 2

- Once the provided data have been stored in a ```List```, convert the ```List``` to a binary tree using a class you've created for this purpose (using ```last_name``` as the key)
- Use a nested class to represent a node in the tree - ONLY IF WE HAVE COVERED THIS AND IT IS APPROPRIATE
- The tree should allow for multiple employees with the same ```last_name```
- Allow the user to search for a specific employee by ```last_name```