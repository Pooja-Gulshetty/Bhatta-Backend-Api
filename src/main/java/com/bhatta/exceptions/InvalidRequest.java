package com.bhatta.exceptions;

public class InvalidRequest extends RuntimeException {
    private final String message;

    public InvalidRequest(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
