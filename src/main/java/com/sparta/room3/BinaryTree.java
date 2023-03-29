package com.sparta.binarySearchTreeProject;

public interface BinaryTree {

        int getRootElement();
        //should return the root node of the tree

        int getNumberOfElements();
        //should traverse through the tree, using either method (Ascending or Descending) order
        //and return the total count of nodes traversed

        void addElement(int element);//should add element in the correct node accordingly
        //-->should traverse through the tree and find the correct node to add element
        //eg. start by traversing either through left child node if the element is less than current
        // node or traversing to the right child node if the element is greater than the current node

        void addElements(int[] elements);

        boolean findElement(int value);

//       int getLeftChild(int element) throws ChildNotFoundException;

//        int getRightChild(int element) throws ChildNotFoundException;

        int[] getSortedTreeAsc();

        int[] getSortedTreeDesc();
    }
