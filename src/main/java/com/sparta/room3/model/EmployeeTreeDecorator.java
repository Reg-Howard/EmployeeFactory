package com.sparta.room3.model;

public class EmployeeTreeDecorator {
    private BinarySearchTree<Employee> tree;
    EmployeeTreeDecorator(BinarySearchTree<Employee> tree){
        this.tree = tree;
    }
}
