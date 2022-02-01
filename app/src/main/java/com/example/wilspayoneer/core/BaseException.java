package com.example.wilspayoneer.core;

/*
 * Base class to create custom exceptions
 */
public class BaseException extends Exception {
    private String message;

    public BaseException(String message) {
        super(message);
        this.setMessage(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
