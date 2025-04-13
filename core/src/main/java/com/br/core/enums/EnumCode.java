package com.br.core.enums;

public enum EnumCode {
    EXA0000("Exam find by examId not found"),
    PAT0000("Patient find by patientId not found"),
    PRO0000("Professional find by professionalId not found"),
    PRO0001("Professional name already exists in database"),
    PAT("Patient find by patientId not found");
    private String message;

    EnumCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
