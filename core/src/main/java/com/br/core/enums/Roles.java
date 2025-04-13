package com.br.core.enums;

public enum Roles {
    DOCTOR("DOCTOR"),
    TECHNICIAN("TECHNICIAN"),
    PATIENT("PATIENT");

    private String roles;

    Roles(String roles){
        this.roles = roles;
    }

    public String getRoles(){
        return this.roles;
    }
}
