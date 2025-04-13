package com.br.infrastructure.gatewayImpl;

import com.br.application.gateway.ExamsEntityGateway;
import com.br.core.entity.ExamsEntity;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.ExamIdNotFound;
import com.br.core.exceptions.PatientIdNotFound;
import com.br.infrastructure.domain.Exams;
import com.br.infrastructure.mapper.ExamsMapper;
import com.br.infrastructure.repositories.ExamsRepository;
import com.br.infrastructure.repositories.PatientRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamsEntityGatewayImpl implements ExamsEntityGateway {

    private final ExamsRepository examsRepository;
    private final ExamsMapper examsMapper;
    private final PatientRepository patientRepository;

    public ExamsEntityGatewayImpl(ExamsRepository examsRepository, ExamsMapper examsMapper, PatientRepository patientRepository){
        this.examsRepository = examsRepository;
        this.examsMapper = examsMapper;
        this.patientRepository = patientRepository;
    }

    @Override
    public void create(ExamsEntity examsEntity) {
        Exams exams = examsMapper.toExams(examsEntity);
        examsRepository.save(exams);
    }

    @Override
    public ExamsEntity findByExamId(Long examId) {
        if(existsByExamId(examId)){
            Exams exams = examsRepository.getReferenceById(examId);
            return examsMapper.toExamsEntity(exams);
        }
        throw new ExamIdNotFound(EnumCode.EXA0000.getMessage());
    }

    @Override
    public boolean existsByExamId(Long examId) {
        return examsRepository.existsByExamId(examId);
    }

    @Override
    public List<ExamsEntity> findAll() {
        return examsMapper.toExamsEntityList(examsRepository.findAll());
    }

    @Override
    public void deleteByExamId(Long examId) {
        if(existsByExamId(examId)){
            examsRepository.deleteById(examId);
        }else{
            throw new ExamIdNotFound(EnumCode.EXA0000.getMessage());
        }
    }

    @Override
    public ExamsEntity update(Long examId, ExamsEntity newExamsEntity) {
        if(existsByExamId(examId)){
            Exams exams = examsRepository.getReferenceById(examId);
            if(newExamsEntity.getDescription() != null){
                exams.setDescription(newExamsEntity.getDescription());
            }
            return examsMapper.toExamsEntity(examsRepository.save(exams));
        }
        throw new ExamIdNotFound(EnumCode.EXA0000.getMessage());
    }

    @Override
    public List<ExamsEntity> findByPatientId(Long patientId) {
        if(patientRepository.existsByPatientId(patientId)){
            List<Exams> examsList = examsRepository.findByPatientId(patientId);
            return examsList.stream().map(examsMapper::toExamsEntity).toList();
        }
        throw new PatientIdNotFound(EnumCode.PAT.getMessage());
    }
}
