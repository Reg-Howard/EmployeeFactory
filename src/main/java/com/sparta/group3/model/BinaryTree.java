package com.sparta.group3.model;

import com.sparta.group3.model.Exceptions.ChildNotFoundException;

import java.util.List;

public interface BinaryTree<T> {

    Comparable<T> getRootElement();

    int getNumberOfElements();

    void addElement(T element);

    void addElements(List<T> elements);

    Comparable<T> findElement(T value);

    T getLeftChild(T element) throws ChildNotFoundException;

    T getRightChild(T element) throws ChildNotFoundException;

    Object[] getSortedTreeAsc();

    Object[] getSortedTreeDesc();
}