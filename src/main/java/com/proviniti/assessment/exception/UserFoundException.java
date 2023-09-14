package com.proviniti.assessment.exception;

public class UserFoundException extends RuntimeException{
    public UserFoundException() {
        super();
    }

    public UserFoundException(String message) {
        super(message);
    }

    public UserFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
