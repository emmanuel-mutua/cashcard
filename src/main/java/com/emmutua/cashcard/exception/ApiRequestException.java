package com.emmutua.cashcard.exception;

/**
 * This is a custom exception that we shall throw
 */
public class ApiRequestException extends RuntimeException{
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
