package com.stackroute.MuzixApplication.exceptions;

public class TrackDoesNotExistsException extends Exception {
    private String message;

    public TrackDoesNotExistsException(String message) {
        super(message);
        this.message = message;
    }
}
