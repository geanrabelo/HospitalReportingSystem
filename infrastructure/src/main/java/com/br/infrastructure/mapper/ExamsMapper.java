package com.br.infrastructure.mapper;

import com.br.core.entity.ExamsEntity;
import com.br.infrastructure.domain.Exams;
import com.br.infrastructure.dto.ExamsDetailsDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamsMapper {

    private final PatientMapper patientMapper;
    private final ProfessionalMapper professionalMapper;

    public ExamsMapper(PatientMapper patientMapper, ProfessionalMapper professionalMapper){
        this.patientMapper = patientMapper;
        this.professionalMapper = professionalMapper;
    }

    public Exams toExams(ExamsEntity examsEntity){
        return Exams.builder()
                .examId(examsEntity.getExamId())
                .name(examsEntity.getName())
                .description(examsEntity.getDescription())
                .price(examsEntity.getPrice())
                .doneIn(examsEntity.getDoneIn())
                .patient(patientMapper.toPatient(examsEntity.getPatientEntity()))
                .professional(professionalMapper.toProfessional(examsEntity.getProfessionalEntity()))
                .build();
    }

    public ExamsEntity toExamsEntity(Exams exams){
        return new ExamsEntity.ExamsEntityBuilder()
                .builder()
                .examId(exams.getExamId())
                .name(exams.getName())
                .description(exams.getDescription())
                .price(exams.getPrice())
                .doneIn(exams.getDoneIn())
                .patient(patientMapper.toPatientEntity(exams.getPatient()))
                .professional(professionalMapper.toProfessionalEntity(exams.getProfessional()))
                .build();
    }

    public ExamsDetailsDTO toExamsDetailsDTO(ExamsEntity examsEntity){
        return new ExamsDetailsDTO(examsEntity);
    }

    public List<Exams> toExamsList(List<ExamsEntity> examsEntityList){
        return examsEntityList.stream().map(this::toExams).toList();
    }

    public List<ExamsEntity> toExamsEntityList(List<Exams> examsList){
        return examsList.stream().map(this::toExamsEntity).toList();
    }
}
