package com.sparta.room3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree<T extends Comparable> implements BinaryTree<T>{

    private class Node<T extends Comparable>{
        private Node leftChildNode, rightChildNode;
        private T value;

        public Node getLeftChildNode() {
            return leftChildNode;
        }

        public Node getRightChildNode() {
            return rightChildNode;
        }

        public void setRightChildNode(Node<T> node){
            this.rightChildNode = node;
        }

        public void setLeftChildNode(Node<T> node){
            this.leftChildNode = node;
        }

        public T getValue(){
            return value;
        }

        public void setValue(T value){
            this.value = value;
        }


    }
    Node<T> root;
    int childCount = 0;

    public BinarySearchTree(){

    }

    public BinarySearchTree(T rootValue){
        root = new Node<T>();
        addElement(rootValue);
    }

    public BinarySearchTree(List<T> values){
        root = new Node<T>();
        addElements(values);
    }

    @Override
    public Comparable<T> getRootElement() {
        return root.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return childCount;
    }

    @Override
    public void addElement(T element) {
        if(root == null){
            this.root = new Node();
        }
        addElement(element, root);
    }

    @Override
    public void addElements(List<T> elements) {
        for(T element : elements){
            addElement(element);
        }
    }

    private void addElement(T element, Node<T> node){
        Comparable<T> nodeValue =  node.getValue();
        if(nodeValue == null){
            node.setValue(element);
            childCount++;
        }else {
            if (element.compareTo(nodeValue) > 0) {
                if (node.getRightChildNode() == null) {
                    node.setRightChildNode(new Node());
                }
                addElement(element, node.getRightChildNode());
            } else {
                if (node.getLeftChildNode() == null) {
                    node.setLeftChildNode(new Node());
                }
                addElement(element, node.getLeftChildNode());
            }
        }
    }

    @Override
    public T findElement(T value) {
        return findElement(root, value);
    }

    public Object[] findElements(T value){
        return findElements(root, value, new ArrayList<>());
    }

    private Object[] findElements(Node node, T value, ArrayList list){
        Comparable<T> nodeValue =  node.getValue();
        if (value.compareTo(nodeValue) > 0) {
            if (node.getRightChildNode() != null) {
                findElements(node.getRightChildNode(), value, list);
            }
        } else if(value.compareTo(nodeValue) < 0) {
            if (node.getLeftChildNode() != null) {
                findElements(node.getLeftChildNode(), value, list);
            }
        }else{
            list.add(node.getValue());
            if (node.getLeftChildNode() != null ) {
                findElements(node.getLeftChildNode(), value, list);
            }
        }
        return list.toArray();
    }

    private T findElement(Node node, T value){
        Comparable<T> nodeValue =  node.getValue();
        if (value.compareTo(nodeValue) > 0) {
            if (node.getRightChildNode() != null) {
                findElement(node.getRightChildNode(), value);
            }
        } else if(value.compareTo(nodeValue) < 0) {
            if (node.getLeftChildNode() != null) {
                findElement(node.getLeftChildNode(), value);
            }
        }else{
            return (T) nodeValue;
        }
        return null;
    }



    @Override
    public Object[] getSortedTreeAsc() {
        ArrayList objects = new ArrayList();
        getTreeElements(root, objects, true);
        return objects.toArray();
    }

    @Override
    public Object[] getSortedTreeDesc() {
        ArrayList objects = new ArrayList();
        getTreeElements(root, objects, false);
        return objects.toArray();
    }

    private void getTreeElements(Node node, ArrayList list, boolean ascending){
        if(ascending){
            if(node.getLeftChildNode() != null)
                getTreeElements(node.getLeftChildNode(), list, ascending);
            list.add(node.getValue());
            if(node.getRightChildNode() != null)
                getTreeElements(node.getRightChildNode(), list, ascending);
        }else{
            if(node.getRightChildNode() != null)
                getTreeElements(node.getRightChildNode(), list, ascending);
            list.add(node.getValue());
            if(node.getLeftChildNode() != null)
                getTreeElements(node.getLeftChildNode(), list, ascending);
        }
    }

}