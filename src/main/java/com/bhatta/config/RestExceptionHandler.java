package com.bhatta.config;

import com.bhatta.exceptions.InvalidRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = InvalidRequest.class)
    public ResponseEntity<String> handleInvalidRequest(InvalidRequest exception) {

    }
}
