# EmployeeFactory - Group 3
# Description Summary for the Repository:
Our repo contains a binary search tree (no balancing capabilities) that takes advantage of generics and can accept any object that implements the comparable interface. We were given a class that assists us with loading values from a CSV that we could then use to generate Employee objects. Our employee class was fitted up with the Comparable interface so that we could use it with our binary search tree. To meet our requirements of having our tree return an array of Employee object when asked for a sorted array we also took advantage of the Decorator design pattern. Our decorator design pattern class allows us to more seamlessly use our Employee objects with the tree, now rather than having to pass an employee object we can pass a String that simply contains the lastName of an employee to fetch their object from the tree, another detail abstracted away would be conversions from Object[] to Employee[]. 

# Requirements to Run These Files:
- JDK 8 or later
- Maven
- JVM <br />
#### Make sure to change the pom.xml to match the version of Java that your JVM supports (8 or later) and then run the following commands:
```
mvn install
```
```
java -cp target/EmployeeFactory-1.0-SNAPSHOT.jar com.sparta.group3.Main
```
# Project Roles: <br />
| Role                  |   Contributer         |           Email                |
|  :---:                |      :---:            |             :---:              |
| Scrum Lead            | Reggie Howard         | RHoward@spartaglobal.com       |
| GitHub Lead           | Abubaker Muhammad     | AMuhammad@spartaglobal.com     |
| Subject-Matter-Expert | Nicholas Thom         | NThom@spartaglobal.com         |
| Dev/tester            | Muhammad Usman Rizwan | MRizwan@spartaglobal.com       |
| Dev/tester            | Ajay Balakrishnan     | ABalakrishnan@spartaglobal.com |
| Dev/tester            | Grzegorz Urbanik      | GUrbanik@spartaglobal.com      |           

# Details of the Functionality in Major Sections
## BinarySearchTree: <br />
[BinarySearchTree.java](https://github.com/bakar212/EmployeeFactory/blob/main/src/main/java/com/sparta/group3/model/BinarySearchTree.java) <br />
Our binary search tree accepts and sorts any object that implements the Comparable interface. It has three constructors, one with no parameters, one that allows specification of the root node's value, and then one that just takes a list of objects. <br>
#### In terms of setter methods we have:
```java
addElement(T element);
```
If the root node has no value the object passed in will fill the root node, otherwise recursion will take care of placing it in our tree structure.
```java
addElements(List<T> elements);
```
If the root node has no value the first in the list will fill the root node. All other objects in the list will be placed recursively in our tree structure.
#### We also have a wide array of getter methods:
```java
public Comparable<T> getRootElement();
```
Gets the root element.
```java
public int getNumberOfElements();
```
Returns the number of objects stored within the tree.
```java
public Comparable<T> findElement(T value);
```
Returns an element if there is a match.
```java
public Object[] findElements(T value);
```
Returns all matched elements.
```java
public T getLeftChild(T element);
```
If a match is found for the given element it returns the value of the child node that is considered to be "less than" the matched element if it exists. If there is no child then a ChildNotFoundException is thrown.
```java
public T getRightChild(T element);
```
If a match is found for the given element it returns the value of the child node that is considered to be "greater than" the matched element if it exists. If there is no child then a ChildNotFoundException is thrown.
```java
public Object[] getSortedTreeAsc();
```
Returns an Object array of all the objects stored within the tree in ascending order.
```java
public Object[] getSortedTreeDesc();
```
Returns an Object array of all the objects stored within the tree in descending order.
## Employee Class <br />
[Employee.java](https://github.com/bakar212/EmployeeFactory/blob/main/src/main/java/com/sparta/group3/model/Employee.java) <br />
class represents an individual employee object. It has private variables for employee number, birth date, first name, last name, gender, and hire date. The class has a constructor that takes employee data as a string and parses it to assign the values to the private variables. It throws an InvalidDataException if the input data is invalid.

The class also has getters for each private variable and overrides the toString method to return formatted employee data. It also implements the Comparable interface to allow sorting of employees based on their last name and first name.

##  Employee List Class <br />
[EmployeeList.java](https://github.com/bakar212/EmployeeFactory/blob/main/src/main/java/com/sparta/group3/model/EmployeeList.java) <br />
The EmployeeList class is a collection of Employee objects stored in an ArrayList. It provides methods to add, retrieve, and print employees, as well as a constructor that takes an array of strings and creates an Employee object for each string in the array. It also overrides the toString method to return a JSON representation of the list of employees. The EmployeeList class follows the Single Responsibility Principle (SRP) by encapsulating the logic related to storing and retrieving employees in a separate class, and also follows the Open-Closed Principle (OCP) by allowing for extension by providing public methods for adding and retrieving employees.
## EmployeeTreeDecorator <br />
[EmployeeTreeDecorator.java](https://github.com/bakar212/EmployeeFactory/blob/main/src/main/java/com/sparta/group3/model/EmployeeTreeDecorator.java) <br />
Our EmployeeTreeDecorator is a class that we made because generics has some limitations which really gave us the choice between greatly limiting re-usability of our BinarySearchTree class or using the Decorator design patter. We opted for the latter. Our decorator class employs all the same public methods as the BinarySearchTree class, but delegates the heavy thinking to BinarySearchTree while giving us the return types and ease of use that our client requires. Take the findElement() method for example: <br />
#### Inside the BinarySearchTree class: <br />
```java
public Comparable<T> findElement(T value) {
  return findElement(root, value);
}
```

It requires an object to find an element and our client wanted to be able to query for an employee while simply using the last name property of the Employee class. <br />
Inside of EmployeeTreeDecorator class:
```java
public Employee findElement(String value) {
    try {
        Employee employee = new Employee("178566,Mrs.,Juliette,M," + value + ",F,juliette.rojo@yahoo.co.uk,05/08/1967,06/04/2011,193912");
        return (Employee) tree.findElement(employee);
    }catch(InvalidDataException e){
        e.printStackTrace();
        return null;
    }
}
```

# Summary of Testing <br />
We used JUnit 5 in our program to unit test our classes. We primarily focused on the getters and setters of every class that we created, but we also made sure to check that exceptions are thrown where they should be. <br />
You can see all of our tests here: [test package](https://github.com/bakar212/EmployeeFactory/tree/main/src/test/java/com/sparta/group3) <br />
# Glossary of Technical Concepts <br />
[docs.oracle.com Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html), [refactoring.guru Decorator Design Pattern](https://refactoring.guru/design-patterns/decorator), [docs.oracle.com Nested Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html), [JUnit 5](https://junit.org/junit5/), [Maven](https://maven.apache.org/), [docs.oracle.com Scanner](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html)
