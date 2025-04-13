package com.br.infrastructure.exceptions;

import com.br.core.exceptions.ExamIdNotFound;
import com.br.core.exceptions.PatientIdNotFound;
import com.br.core.exceptions.ProfessionalIdNotFound;
import com.br.core.exceptions.ProfessionalNameAlreadyExists;
import com.br.infrastructure.exceptions.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProfessionalIdNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse professionalIdNotFoundHandler(ProfessionalIdNotFound professionalIdNotFound){
        return ErrorResponse.notFound(professionalIdNotFound.getMessage());
    }

    @ExceptionHandler(ProfessionalNameAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse professionalNameAlreadyExistsHandler(ProfessionalNameAlreadyExists professionalNameAlreadyExists){
        return ErrorResponse.conflict(professionalNameAlreadyExists.getMessage());
    }

    @ExceptionHandler(PatientIdNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse patientIdNotFoundHandler(PatientIdNotFound patientIdNotFound){
        return ErrorResponse.notFound(patientIdNotFound.getMessage());
    }

    @ExceptionHandler(ExamIdNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse examIdNotFoundHandler(ExamIdNotFound examIdNotFound){
        return ErrorResponse.notFound(examIdNotFound.getMessage());
    }
}
