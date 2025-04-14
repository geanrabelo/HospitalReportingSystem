package com.br.usecases;

import com.br.core.entity.ExamsEntity;
import com.br.core.entity.PatientEntity;

import java.util.List;

public interface PatientEntityUsecases {

    void create(PatientEntity patientEntity);

    PatientEntity findByPatientId(Long patientId);

    boolean existsByPatientId(Long patientId);

    List<PatientEntity> findAll();

    void deleteByPatientId(Long patientId);

    PatientEntity update(Long patientId, PatientEntity newPatientEntity);

}
