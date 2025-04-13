package com.br.infrastructure.dto;

import com.br.core.entity.ExamsEntity;
import com.br.core.enums.ExamsEnum;
import java.time.LocalDateTime;

public record ExamsDetailsPatientDTO(Long examId,
                                     ExamsEnum examsEnum,
                                     String description,
                                     Float price,
                                     LocalDateTime doneIn) {

    public ExamsDetailsPatientDTO(ExamsEntity examsEntity){
        this(examsEntity.getExamId(),
                examsEntity.getName(),
                examsEntity.getDescription(),
                examsEntity.getPrice(),
                examsEntity.getDoneIn());
    }
}
