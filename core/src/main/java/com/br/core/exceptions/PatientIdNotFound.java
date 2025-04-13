package com.br.core.exceptions;

public class PatientIdNotFound extends RuntimeException {
    public PatientIdNotFound(String message) {
        super(message);
    }
}
