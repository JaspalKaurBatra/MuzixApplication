package com.stackroute.MuzixApplication.exceptions;

public class NullValuesException extends Exception{

    private String message;

    public NullValuesException(String message) {
        super(message);
        this.message = message;
    }
}
