package com.bhatta.exceptions;

public class ConflictException extends RuntimeException {
  private final String message;

  public ConflictException(final String message) {
    super(message);
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
