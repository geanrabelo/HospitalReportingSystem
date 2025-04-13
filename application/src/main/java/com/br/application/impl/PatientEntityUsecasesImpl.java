package com.br.application.impl;

import com.br.application.gateway.PatientEntityGateway;
import com.br.core.entity.PatientEntity;
import com.br.usecases.PatientEntityUsecases;

import java.util.List;

public class PatientEntityUsecasesImpl implements PatientEntityUsecases {

    private final PatientEntityGateway patientEntityGateway;

    public PatientEntityUsecasesImpl(PatientEntityGateway patientEntityGateway){
        this.patientEntityGateway = patientEntityGateway;
    }

    @Override
    public void create(PatientEntity patientEntity) {
        patientEntityGateway.create(patientEntity);
    }

    @Override
    public PatientEntity findByPatientId(Long patientId) {
        return patientEntityGateway.findByPatientId(patientId);
    }

    @Override
    public boolean existsByPatientId(Long patientId) {
        return false;
    }

    @Override
    public List<PatientEntity> findAll() {
        return patientEntityGateway.findAll();
    }

    @Override
    public void deleteByPatientId(Long patientId) {
        patientEntityGateway.deleteByPatientId(patientId);
    }

    @Override
    public PatientEntity update(Long patientId, PatientEntity newPatientEntity) {
        return patientEntityGateway.update(patientId, newPatientEntity);
    }
}
