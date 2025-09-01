package com.karma.clair.exceptions;

public class UsernameAlreadyRegisteredException extends RuntimeException {
    public UsernameAlreadyRegisteredException() {
        super("Username already registered");
    }
}
