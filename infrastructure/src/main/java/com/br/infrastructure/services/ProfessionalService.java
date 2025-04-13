package com.br.infrastructure.services;

import com.br.infrastructure.dto.ProfessionalCreationDTO;
import com.br.infrastructure.dto.ProfessionalDetailsDTO;

import java.net.URI;
import java.util.List;

public interface ProfessionalService {

    URI create(ProfessionalCreationDTO professionalCreationDTO);

    List<ProfessionalDetailsDTO> findAll();

    ProfessionalDetailsDTO findByProfessionalId(Long professionalId);

    void deleteByProfessionalId(Long professionalId);

    ProfessionalDetailsDTO update(Long professionalId, ProfessionalCreationDTO professionalCreationDTO);
}
