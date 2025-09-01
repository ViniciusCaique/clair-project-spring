package com.karma.clair.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Resource Not found");
    }
}
