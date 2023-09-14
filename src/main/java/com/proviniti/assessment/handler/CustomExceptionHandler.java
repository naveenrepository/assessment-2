package com.proviniti.assessment.handler;

import com.proviniti.assessment.exception.UserFoundException;
import com.proviniti.assessment.exception.UserNotFoundException;
import com.proviniti.assessment.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Response> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(Response.builder().message(ex.getMessage()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<Response> handleUserFoundException(UserFoundException ex) {
        return new ResponseEntity<>(Response.builder().message(ex.getMessage()).build(), HttpStatus.FOUND);
    }
}
