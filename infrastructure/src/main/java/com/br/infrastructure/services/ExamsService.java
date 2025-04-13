package com.br.infrastructure.services;

import com.br.infrastructure.dto.ExamsCreationDTO;
import com.br.infrastructure.dto.ExamsDetailsDTO;
import com.br.infrastructure.dto.ExamsDetailsPatientDTO;

import java.util.List;

public interface ExamsService {

    void create(ExamsCreationDTO examsCreationDTO);

    ExamsDetailsDTO findByExamId(Long examId);

    List<ExamsDetailsDTO> findAll();

    void deleteByExamId(Long examId);

    ExamsDetailsDTO update(Long examId, ExamsCreationDTO examsCreationDTO);

    List<ExamsDetailsPatientDTO> findByPatientId(Long patientId);

}
