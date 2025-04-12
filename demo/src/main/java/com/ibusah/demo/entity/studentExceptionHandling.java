package com.ibusah.demo.entity;

public class studentExceptionHandling extends RuntimeException {

    public studentExceptionHandling(String message) {
        super(message);
    }

    public studentExceptionHandling(String message, Throwable cause) {
        super(message, cause);
    }

    public studentExceptionHandling(Throwable cause) {
        super(cause);
    }
}
