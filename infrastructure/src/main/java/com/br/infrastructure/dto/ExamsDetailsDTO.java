package com.br.infrastructure.dto;

import com.br.core.entity.ExamsEntity;
import com.br.core.enums.ExamsEnum;
import com.br.infrastructure.domain.Patient;
import com.br.infrastructure.domain.Professional;
import com.br.infrastructure.mapper.PatientMapper;
import com.br.infrastructure.mapper.ProfessionalMapper;

import java.time.LocalDateTime;

public record ExamsDetailsDTO(Long examId,
                              ExamsEnum examsEnum,
                              String description,
                              Float price,
                              LocalDateTime doneIn,
                              Patient patient,
                              Professional professional) {

    private static PatientMapper patientMapper = new PatientMapper();
    private static ProfessionalMapper professionalMapper = new ProfessionalMapper();

    public ExamsDetailsDTO(ExamsEntity examsEntity){
        this(examsEntity.getExamId(),
                examsEntity.getName(),
                examsEntity.getDescription(),
                examsEntity.getPrice(),
                examsEntity.getDoneIn(),
                patientMapper.toPatient(examsEntity.getPatientEntity()),
                professionalMapper.toProfessional(examsEntity.getProfessionalEntity()));
    }
}
