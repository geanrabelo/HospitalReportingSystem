package com.br.application.gateway;

import com.br.core.entity.PatientEntity;

import java.util.List;

public interface PatientEntityGateway {

    void create(PatientEntity patientEntity);

    PatientEntity findByPatientId(Long patientId);

    boolean existsByPatientId(Long patientId);

    List<PatientEntity> findAll();

    void deleteByPatientId(Long patientId);

    PatientEntity update(Long patientId, PatientEntity newPatientEntity);

}
