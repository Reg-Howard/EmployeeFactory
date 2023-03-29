package com.sparta.binarySearchTreeProject;

public class BinarySearchTree implements BinaryTree{
    BinarySearchTree parent;
    BinarySearchTree leftChild;
    BinarySearchTree rightChild;
    int inputValue; // This is the input data for the whole search. // Will for now leave this as a non array, but it won't stay like that.



    //     >;v // why >;v ? :O // I don't understand why we would have an array there tbh
    //also if we intend to switch it to an array we should do that otherwise code
    //will become disfunctional that was written with it being just an int
    // well we were given this and isn't it gonna be more fun this way?
    //our methods should probably use or create the array I would think
    //Each node will hold an int value
    // I'm pretty sure we can do anything with this as long as its following OOp and solid methods and as long as it works?
    //

    public int getRootElement(){ //written by nick ask if you need clarification
        //also like probably should test at some point because I am the stoopid // its all good, we are gonna have a lot of fun :0
        if(parent == null){  //this means we are at root;
            return inputValue;
        }
        return parent.getRootElement();
    }

    public int getNumberOfElements(){
        return 1;
    }


    public void addElement(int element){

    }

    public void addElements(int[] elements){
        return;
    }

    public boolean findElement(int value){
        return true;
    }

    int getLeftChild(int element) throws ChildNotFoundException{
        return 0;
    }

    int getRightChild(int element) throws ChildNotFoundException{
        return 0;
    }

    public int[] getSortedTreeAsc(){
        return new int[] {};
    }

    public int[] getSortedTreeDesc(){
        return new int[] {};
    }
}
