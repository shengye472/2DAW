package com.fpmislata.common.exception;

public class ValidationException extends RuntimeException {
    private static final String DESCRIPTION = "Validation error";

    public ValidationException(String message) {
        super(DESCRIPTION + ": " + message);
    }
}
