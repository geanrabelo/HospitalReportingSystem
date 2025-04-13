package com.br.core.exceptions;

public class UserIdNotFound extends RuntimeException {
    public UserIdNotFound(String message) {
        super(message);
    }
}
