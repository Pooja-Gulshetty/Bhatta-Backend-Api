package com.bhatta.config;

import com.bhatta.dto.ErrorDto;
import com.bhatta.exceptions.ConflictException;
import com.bhatta.exceptions.InvalidRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(value = InvalidRequest.class)
  public ResponseEntity<ErrorDto> handleInvalidRequest(InvalidRequest exception) {
    return new ResponseEntity<>(new ErrorDto(exception.getMessage()), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = ConflictException.class)
  public ResponseEntity<ErrorDto> handleConflictException(ConflictException exception) {
    return new ResponseEntity<>(new ErrorDto(exception.getMessage()), HttpStatus.CONFLICT);
  }
}
