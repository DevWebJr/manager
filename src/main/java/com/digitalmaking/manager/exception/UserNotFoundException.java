package com.digitalmaking.manager.exception;

public class UserNotFoundException extends RuntimeException {
    /**
     * @param message
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}