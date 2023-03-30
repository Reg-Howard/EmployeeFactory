package com.sparta.room3.model;

import lombok.*;

public class BinarySearchTree<T extends Comparable<T>>
        implements BinaryTree<T> {
    /*
        Comments here to explain what's going on to technical individuals.
        The @Data annotation was a few features to it so enjoy reading, https://projectlombok.org/features/Data
        Then a nested node class has been created making it as generic as possible allowing for any type of input.
        Next an object called data is declared that again uses generic type. Followed by two objects that are the same
        type as the node class.
     */
    @Data
    public class Node<T extends Comparable<T>> {
        @NonNull private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;
    }
    /*
       First we declare a root object of the same type as the class.
       Then we have overridden the isEmpty method and returned true based on the new root object's content.
       Followed by the overridden getRootElement which returns the value of root
    */
    private Node<T> root;

    @Override
    public boolean isEmpty() {
        return (root == null);
    }
    @Override
    public Node getRootElement(){
        return root;
    }
    /*
       To retrieve the minimum node value from the list we start by checking for an empty tree.
       Then assuming the minimum value is stored on the far left side of the tree, which a sorted binary tree should be,
       we can then continuously iterate down the left value of the tree until a null value is returned, in other words we
       have reached the end fo the tree. At this point we know we have found our smallest node. This data is then returned.
    */
    @Override
    public T getMinValue() {
        if (isEmpty()) {
            return null;
        }
        Node<T> node = root;
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node.getData();
    }
    // An almost identical method used for getting the maximum node value.
    @Override
    public T getMaxValue() {
        if (isEmpty()) {
            return null;
        }
        Node<T> node = root;
        while (node.getRightChild() != null) {
            node = node.getRightChild();
        }
        return node.getData();
    }
    /*
       This is where we implement the traverse method. There are three options for traversal. InOrder, PreOrder, or
       PostOrder. I will only discuss InOrder as that is the method we are going to use, however I have left the other
       options here in case we would want to change methods used at some point in the project. For all traversals we begin
       at root. InOrder traversal works by first checking that node is not empty. After this we first check the value of
       the left node, then the center node and then the right node to get them in value order. However, we need to check
       for child nodes of those nodes. To do this we recursively call the same traverse method on each of the child nodes.
     */
    @Override
    public void traverseTree() {
        traverseInOrder(root);
//        traversePreOrder(root);
//        traversePostOrder(root);
    }
    private void traverseInOrder(Node<T> node) {
        if(node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.println(node);
//            return(node);
            traverseInOrder(node.getRightChild());
        }
    }
    private void traversePreOrder(Node<T> node) {
        if(node != null) {
            System.out.println(node);
//            return(node);
            traverseInOrder(node.getLeftChild());
            traverseInOrder(node.getRightChild());
        }
    }
    private void traversePostOrder(Node<T> node) {
        if(node != null) {
            traverseInOrder(node.getLeftChild());
            traverseInOrder(node.getRightChild());
            System.out.println(node);
//            return(node);
        }
    }

}