package com.br.infrastructure.interfaces.impl;

import com.br.core.entity.ExamsEntity;
import com.br.infrastructure.dto.ExamsCreationDTO;
import com.br.infrastructure.dto.ExamsDetailsDTO;
import com.br.infrastructure.dto.ExamsDetailsPatientDTO;
import com.br.infrastructure.interfaces.ExamsService;
import com.br.infrastructure.mapper.ExamsMapper;
import com.br.usecases.ExamsEntityUsecases;
import com.br.usecases.PatientEntityUsecases;
import com.br.usecases.ProfessionalEntityUsecases;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamsServiceImpl implements ExamsService {

    private final ExamsEntityUsecases examsEntityUsecases;
    private final PatientEntityUsecases patientEntityUsecases;
    private final ProfessionalEntityUsecases professionalEntityUsecases;
    private final ExamsMapper examsMapper;

    public ExamsServiceImpl(ExamsEntityUsecases examsEntityUsecases,
                            ExamsMapper examsMapper,
                            PatientEntityUsecases patientEntityUsecases,
                            ProfessionalEntityUsecases professionalEntityUsecases){
        this.examsEntityUsecases = examsEntityUsecases;
        this.examsMapper = examsMapper;
        this.patientEntityUsecases = patientEntityUsecases;
        this.professionalEntityUsecases = professionalEntityUsecases;
    }

    @Override
    public void create(ExamsCreationDTO examsCreationDTO) {
        ExamsEntity examsEntity = new ExamsEntity.ExamsEntityBuilder()
                .builder()
                        .name(examsCreationDTO.name())
                        .description(examsCreationDTO.description())
                        .patient(patientEntityUsecases.findByPatientId(examsCreationDTO.patientId()))
                        .professional(professionalEntityUsecases.findByProfessionalId(examsCreationDTO.professionalId()))
                .build();
        examsEntityUsecases.create(examsEntity);
    }

    @Override
    public ExamsDetailsDTO findByExamId(Long examId) {
        ExamsEntity examsEntity = examsEntityUsecases.findByExamId(examId);
        return examsMapper.toExamsDetailsDTO(examsEntity);
    }

    @Override
    public List<ExamsDetailsDTO> findAll() {
        return examsEntityUsecases.findAll().stream().map(ExamsDetailsDTO::new).toList();
    }

    @Override
    public void deleteByExamId(Long examId) {
        examsEntityUsecases.deleteByExamId(examId);
    }

    @Override
    public ExamsDetailsDTO update(Long examId, ExamsCreationDTO examsCreationDTO) {
        ExamsEntity examsEntity = new ExamsEntity(examsCreationDTO.description());
        return examsMapper.toExamsDetailsDTO(examsEntityUsecases.update(examId, examsEntity));
    }

    @Override
    public List<ExamsDetailsPatientDTO> findByPatientId(Long patientId) {
        List<ExamsEntity> examsEntityList = examsEntityUsecases.findByPatientId(patientId);
        return examsEntityList.stream().map(ExamsDetailsPatientDTO::new).toList();
    }
}
