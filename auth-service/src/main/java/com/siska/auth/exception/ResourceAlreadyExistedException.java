package com.siska.auth.exception;

public class ResourceAlreadyExistedException extends RuntimeException {
    public ResourceAlreadyExistedException(String message) {
        super(message);
    }
}
