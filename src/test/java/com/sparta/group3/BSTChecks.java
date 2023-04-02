package com.sparta.group3;

import com.sparta.group3.model.BinarySearchTree;
import com.sparta.group3.model.Employee;
import com.sparta.group3.model.EmployeeList;
import com.sparta.group3.model.EmployeeTreeDecorator;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSTChecks {
    @Test
    @DisplayName("Test if the size of the tree is correct")
    public void testSize() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.addElement(5);
        tree.addElement(3);
        tree.addElement(7);
        Assertions.assertEquals(3, tree.getNumberOfElements());
    }

//    @Test // No existing tree height method, test un-necessary.
//    @DisplayName("Test if the height of the tree is correct")
//    public void testHeight() {
//        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
//        tree.addElement(5);
//        tree.addElement(3);
//        tree.addElement(7);
//        tree.addElement(1);
//        tree.addElement(9);
//        Assertions.assertEquals(3, tree.height());
//    }

//    @Test // Duplicate test, test un-necessary.
//    @DisplayName("Test addElement and getNumberOfElements")
//    public void testAddElementAndGetNumberOfElements() {
//        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
//        binaryTree.addElement(5);
//        binaryTree.addElement(3);
//        binaryTree.addElement(7);
//        Assertions.assertEquals(3, binaryTree.getNumberOfElements());
//    }

    @Test
    @DisplayName("Test addElements and getSortedTreeAsc")
    public void testAddElementsAndGetSortedTreeAsc() {
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        List<Integer> elements = new ArrayList<>();
        elements.add(5);
        elements.add(3);
        elements.add(7);
        binaryTree.addElements(elements);
        Object[] expected = {3, 5, 7};
        Assertions.assertTrue(Arrays.equals(expected, binaryTree.getSortedTreeAsc()));
    }

    @Test
    @DisplayName("Test findElement")
    public void testFindElement() {
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.addElement(5);
        binaryTree.addElement(3);
        binaryTree.addElement(7);
        Comparable<Integer> result = binaryTree.findElement(7);
        Assertions.assertEquals(7, result);
    }

    @Test
    @DisplayName("Test getLeftChild")
    public void testGetLeftChild() {
        try {
            BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
            binaryTree.addElement(5);
            binaryTree.addElement(3);
            binaryTree.addElement(7);
            Integer result = binaryTree.getLeftChild(5);
            Assertions.assertEquals(3, result);
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    @DisplayName("Test getRightChild")
    public void testGetRightChild() {
        try {
            BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
            binaryTree.addElement(5);
            binaryTree.addElement(3);
            binaryTree.addElement(7);
            Integer result = binaryTree.getRightChild(5);
            Assertions.assertEquals(7, result);
        } catch (Exception e){
            Assertions.fail();
        }
    }
}