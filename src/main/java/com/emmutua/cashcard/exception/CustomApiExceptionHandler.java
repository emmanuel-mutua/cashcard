package com.emmutua.cashcard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

//Tell spring that this class handles multiple exceptions
@ControllerAdvice
public class CustomApiExceptionHandler {
    //Tell spring this is the exception handler
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        //create a payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z")),
                e
        );
        //return response entity
        return new ResponseEntity<>(apiException, badRequest);
    }
}
