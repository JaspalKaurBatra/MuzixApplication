package com.stackroute.MuzixApplication.controller;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exceptions.NullValuesException;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixApplication.exceptions.TrackDoesNotExistsException;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Track already exists")
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public void handleTrackAlreadyExistsException(TrackAlreadyExistsException e) {

    }

    //@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Track does not exist")
    @ExceptionHandler(TrackDoesNotExistsException.class)
    public ResponseEntity<?> handleTrackDoesNotExistsException(TrackDoesNotExistsException e) {
        return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Null values passed")
    @ExceptionHandler(NullValuesException.class)
    public void handleNullValuesException(NullValuesException e) {
    }
}
/*
@ControllerAdvice
@Log4j
public class GlobalExceptionHandler {


    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="User does not exist")
    @ExceptionHandler(TrackDoesNotExistsException.class)
    public void handleUserDoesNotExistException(TrackDoesNotExistsException e){
        log.error("User does not exist", e);
    }

}*/
