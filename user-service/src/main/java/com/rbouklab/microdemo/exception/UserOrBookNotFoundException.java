package com.rbouklab.microdemo.exception;

public class UserOrBookNotFoundException extends RuntimeException {
    public UserOrBookNotFoundException(String exception) {
        super(exception);
    }
}
