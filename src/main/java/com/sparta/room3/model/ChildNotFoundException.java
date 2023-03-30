package com.sparta.room3.model;

public class ChildNotFoundException extends Exception{
    public ChildNotFoundException() {
        super("Exception: no child element found");
    }
}
