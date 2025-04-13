package com.br.usecases;

import com.br.core.entity.ExamsEntity;

import java.util.List;

public interface ExamsEntityUsecases {

    void create(ExamsEntity examsEntity);

    ExamsEntity findByExamId(Long examId);

    boolean existsByExamId(Long examId);

    List<ExamsEntity> findAll();

    void deleteByExamId(Long examId);

    ExamsEntity update(Long examId, ExamsEntity newExamsEntity);

    List<ExamsEntity> findByPatientId(Long patientId);
}
