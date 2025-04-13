package com.br.application.gateway;

import com.br.core.entity.ExamsEntity;

import java.util.List;

public interface ExamsEntityGateway {

    void create(ExamsEntity examsEntity);

    ExamsEntity findByExamId(Long examId);

    boolean existsByExamId(Long examId);

    List<ExamsEntity> findAll();

    void deleteByExamId(Long examId);

    ExamsEntity update(Long examId, ExamsEntity newExamsEntity);

    List<ExamsEntity> findByPatientId(Long patientId);
}
