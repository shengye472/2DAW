package com.fpmislata.common.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String message) {
        super("Resource already exists. " + message);
    }
}
