package com.sparta.group3.model.Exceptions;

public class InvalidDataException extends Exception{
    public InvalidDataException(){
        super("Invalid data detected, missing value");
    }
}