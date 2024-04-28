package com.emmutua.cashcard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

//Tell spring that this class handles multiple exceptions
@ControllerAdvice
public class CustomApiExceptionHandler {
    //Tell spring this is the exception handler
    HttpStatus badRequest = HttpStatus.BAD_REQUEST;
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        //create a payload containing exception details
        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        //return response entity
        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public ResponseEntity<Object> handleMissingParams(MissingServletRequestParameterException e){
        String param = e.getParameterName();
        ApiException apiException = new ApiException(
                "Missing parameter: " + param,
               badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, badRequest);
    }

    //Missing request body
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<Object> handleMissingReqBody(HttpMessageNotReadableException e){
        ApiException apiException = new ApiException(
                "Request body is missing or cannot be read",
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, badRequest);
    }

}

