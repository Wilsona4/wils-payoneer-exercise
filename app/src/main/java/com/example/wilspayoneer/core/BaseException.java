package com.example.wilspayoneer.core;

public class BaseException extends Exception {
    private String code;

    public BaseException(String message) {
        super(message);
        this.setCode(code);
    }
    public BaseException(String message, String code) {
        super(message);
        this.setCode(code);
    }

    public BaseException(String message, String code, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
