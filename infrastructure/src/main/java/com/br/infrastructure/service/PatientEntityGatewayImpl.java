package com.br.infrastructure.service;

import com.br.application.gateway.PatientEntityGateway;
import com.br.core.entity.PatientEntity;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.PatientIdNotFound;
import com.br.infrastructure.domain.Patient;
import com.br.infrastructure.mapper.PatientMapper;
import com.br.infrastructure.repositories.PatientRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientEntityGatewayImpl implements PatientEntityGateway {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientEntityGatewayImpl(PatientRepository patientRepository, PatientMapper patientMapper){
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public void create(PatientEntity patientEntity) {
        Patient patient = patientMapper.toPatient(patientEntity);
        patientRepository.save(patient);
    }

    @Override
    public PatientEntity findByPatientId(Long patientId) {
        if(existsByPatientId(patientId)){
            Patient patient = patientRepository.getReferenceById(patientId);
            return patientMapper.toPatientEntity(patient);
        }
        throw new PatientIdNotFound(EnumCode.PAT.getMessage());
    }

    @Override
    public boolean existsByPatientId(Long patientId) {
        return patientRepository.existsByPatientId(patientId);
    }

    @Override
    public List<PatientEntity> findAll() {
        return patientMapper.toListPatientEntity(patientRepository.findAll());
    }

    @Override
    public void deleteByPatientId(Long patientId) {
        if(existsByPatientId(patientId)){
            patientRepository.deleteById(patientId);
        }else{
            throw new PatientIdNotFound(EnumCode.PAT.getMessage());
        }
    }

    @Override
    public PatientEntity update(Long patientId, PatientEntity newPatientEntity) {
        if(existsByPatientId(patientId)){
            Patient patient = patientRepository.getReferenceById(patientId);
            if(newPatientEntity.getNumberPhone() != null){
                patient.setNumberPhone(newPatientEntity.getNumberPhone());
            }
            return patientMapper.toPatientEntity(patientRepository.save(patient));
        }
        throw new PatientIdNotFound(EnumCode.PAT.getMessage());
    }
}
