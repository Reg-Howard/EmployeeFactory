package com.sparta.room3.model.Exceptions;

public class InvalidDataException extends Exception{
    public InvalidDataException(){
        super("Invalid data detected, missing value");
    }

    public InvalidDataException(String customMessage){
        super(customMessage);
    }

}
