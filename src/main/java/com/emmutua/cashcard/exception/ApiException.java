package com.emmutua.cashcard.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {
    private final String message;
    private Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public ApiException(
            String message,
            HttpStatus httpStatus,
            ZonedDateTime timestamp,
            Throwable throwable) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
        this.throwable = throwable;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
