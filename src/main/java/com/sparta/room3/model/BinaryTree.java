package com.sparta.room3.model;



public interface BinaryTree<T extends Comparable<T>> {

        BinaryTree<T> insertData(T data);
        void traverseTree();
        T getMaxValue();
        T getMinValue();
        boolean isEmpty();
        //should

        BinarySearchTree.Node getRootElement();
        //should return the root node of the tree

        int getNumberOfElements();                                                              // Still Needs Writing
        //should traverse through the tree, using either method (Ascending or Descending) order
        //and return the total count of nodes traversed

        void addElement(int element);//should add element in the correct node accordingly       // Still Needs Writing - connect to insert
        //-->should traverse through the tree and find the correct node to add element
        //eg. start by traversing either through left child node if the element is less than current
        // node or traversing to the right child node if the element is greater than the current node

        void addElements(int[] elements);                                                       // Still Needs Writing - connect to insert

        boolean findElement(int value);                                                         // Still Needs Writing

//       T getLeftChild(T element) throws ChildNotFoundException;                           // Still Needs Writing

//       T getRightChild(T element) throws ChildNotFoundException;                          // Still Needs Writing

        T[] getSortedTreeAsc();                                                               // Still Needs Writing

        T[] getSortedTreeDesc();                                                              // Still Needs Writing
    }
