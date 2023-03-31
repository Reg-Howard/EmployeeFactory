package com.sparta.room3.model;

import java.util.List;

public interface BinaryTree<T> {

    Comparable<T> getRootElement();

    int getNumberOfElements();

    void addElement(T element);

    void addElements(List<T> elements);

    T findElement(T value);

   // int getLeftChild(int element) throws ChildNotFoundException;

   // int getRightChild(int element) throws ChildNotFoundException;

    Object[] getSortedTreeAsc();

    Object[] getSortedTreeDesc();
}