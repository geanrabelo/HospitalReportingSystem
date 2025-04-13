package com.br.infrastructure.mapper;

import com.br.core.entity.PatientEntity;
import com.br.infrastructure.domain.Patient;
import com.br.infrastructure.dto.PatientDetailsDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientMapper {

    public Patient toPatient(PatientEntity patientEntity){
        return Patient.builder()
                .patientId(patientEntity.getPatientId())
                .name(patientEntity.getName())
                .age(patientEntity.getAge())
                .numberPhone(patientEntity.getNumberPhone())
                .registeredAt(patientEntity.getRegisteredAt())
                .build();
    }

    public PatientEntity toPatientEntity(Patient patient){
        return new PatientEntity.PatientEntityBuilder()
                .builder()
                .patientId(patient.getPatientId())
                .name(patient.getName())
                .age(patient.getAge())
                .numberPhone(patient.getNumberPhone())
                .registeredAt(patient.getRegisteredAt())
                .build();
    }

    public PatientDetailsDTO toPatientDetailsDTO(PatientEntity patientEntity){
        return new PatientDetailsDTO(patientEntity);
    }

    public List<PatientEntity> toListPatientEntity(List<Patient> patientList){
        return patientList.stream().map(this::toPatientEntity).toList();
    }

    public List<Patient> toListPatient(List<PatientEntity> patientEntityList){
        return patientEntityList.stream().map(this::toPatient).toList();
    }
}
