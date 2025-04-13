package com.br.infrastructure.interfaces;

import com.br.infrastructure.dto.PatientCreationDTO;
import com.br.infrastructure.dto.PatientDetailsDTO;

import java.net.URI;
import java.util.List;

public interface PatientService {

    URI create(PatientCreationDTO patientCreationDTO);

    PatientDetailsDTO findByPatientId(Long patientId);

    List<PatientDetailsDTO> findAll();

    void deleteByPatientId(Long patientId);

    PatientDetailsDTO update(Long patientId, PatientCreationDTO patientCreationDTO);
}
