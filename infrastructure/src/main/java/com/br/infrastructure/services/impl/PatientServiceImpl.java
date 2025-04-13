package com.br.infrastructure.services.impl;

import com.br.core.entity.PatientEntity;
import com.br.infrastructure.dto.PatientCreationDTO;
import com.br.infrastructure.dto.PatientDetailsDTO;
import com.br.infrastructure.services.PatientService;
import com.br.infrastructure.mapper.PatientMapper;
import com.br.usecases.PatientEntityUsecases;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientEntityUsecases patientEntityUsecases;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientEntityUsecases patientEntityUsecases, PatientMapper patientMapper) {
        this.patientEntityUsecases = patientEntityUsecases;
        this.patientMapper = patientMapper;
    }

    @Override
    public URI create(PatientCreationDTO patientCreationDTO) {
        PatientEntity patientEntity = new PatientEntity.PatientEntityBuilder().builder()
                        .name(patientCreationDTO.name())
                        .age(patientCreationDTO.age())
                        .numberPhone(patientCreationDTO.numberPhone())
                        .build();
        patientEntityUsecases.create(patientEntity);
        return UriComponentsBuilder.fromPath("/hrs/patient").buildAndExpand().toUri();
    }

    @Override
    public PatientDetailsDTO findByPatientId(Long patientId) {
        PatientEntity patientEntity = patientEntityUsecases.findByPatientId(patientId);
        return patientMapper.toPatientDetailsDTO(patientEntity);
    }

    @Override
    public List<PatientDetailsDTO> findAll() {
        return patientEntityUsecases.findAll().stream().map(patientMapper::toPatientDetailsDTO).toList();
    }

    @Override
    public void deleteByPatientId(Long patientId) {
        patientEntityUsecases.deleteByPatientId(patientId);
    }

    @Override
    public PatientDetailsDTO update(Long patientId, PatientCreationDTO patientCreationDTO) {
        PatientEntity patientEntity = new PatientEntity.PatientEntityBuilder()
                .builder()
                .numberPhone(patientCreationDTO.numberPhone())
                .build();
        return patientMapper.toPatientDetailsDTO(patientEntityUsecases.update(patientId, patientEntity));
    }
}
