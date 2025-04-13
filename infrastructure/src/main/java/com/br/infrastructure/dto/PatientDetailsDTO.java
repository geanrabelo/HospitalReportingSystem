package com.br.infrastructure.dto;

import com.br.core.entity.PatientEntity;

import java.time.LocalDateTime;

public record PatientDetailsDTO(Long patientId,
                                String name,
                                Integer age,
                                String numberPhone,
                                LocalDateTime registeredAt) {
    public PatientDetailsDTO(PatientEntity patientEntity){
        this(patientEntity.getPatientId(),
                patientEntity.getName(),
                patientEntity.getAge(),
                patientEntity.getNumberPhone(),
                patientEntity.getRegisteredAt());
    }
}
