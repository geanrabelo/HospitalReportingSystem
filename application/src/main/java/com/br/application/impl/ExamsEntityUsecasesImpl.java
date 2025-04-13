package com.br.application.impl;

import com.br.application.gateway.ExamsEntityGateway;
import com.br.core.entity.ExamsEntity;
import com.br.usecases.ExamsEntityUsecases;

import java.util.List;

public class ExamsEntityUsecasesImpl implements ExamsEntityUsecases {

    private final ExamsEntityGateway examsEntityGateway;

    public ExamsEntityUsecasesImpl(ExamsEntityGateway examsEntityGateway){
        this.examsEntityGateway = examsEntityGateway;
    }

    @Override
    public void create(ExamsEntity examsEntity) {
        examsEntityGateway.create(examsEntity);
    }

    @Override
    public ExamsEntity findByExamId(Long examId) {
        return examsEntityGateway.findByExamId(examId);
    }

    @Override
    public boolean existsByExamId(Long examId) {
        return false;
    }

    @Override
    public List<ExamsEntity> findAll() {
        return examsEntityGateway.findAll();
    }

    @Override
    public void deleteByExamId(Long examId) {
        examsEntityGateway.deleteByExamId(examId);
    }

    @Override
    public ExamsEntity update(Long examId, ExamsEntity newExamsEntity) {
        return examsEntityGateway.update(examId, newExamsEntity);
    }

    @Override
    public List<ExamsEntity> findByPatientId(Long patientId) {
        return examsEntityGateway.findByPatientId(patientId);
    }
}
