package com.br.infrastructure.services.impl;

import com.br.core.entity.ProfessionalEntity;
import com.br.infrastructure.dto.ProfessionalCreationDTO;
import com.br.infrastructure.dto.ProfessionalDetailsDTO;
import com.br.infrastructure.services.ProfessionalService;
import com.br.infrastructure.mapper.ProfessionalMapper;
import com.br.usecases.ProfessionalEntityUsecases;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    private final ProfessionalEntityUsecases professionalEntityUsecases;
    private final ProfessionalMapper professionalMapper;

    public ProfessionalServiceImpl(ProfessionalEntityUsecases professionalEntityUsecases, ProfessionalMapper professionalMapper){
        this.professionalEntityUsecases = professionalEntityUsecases;
        this.professionalMapper = professionalMapper;
    }

    @Override
    public URI create(ProfessionalCreationDTO professionalCreationDTO) {
        professionalEntityUsecases.create(new ProfessionalEntity(professionalCreationDTO.name(), professionalCreationDTO.area()));

        return UriComponentsBuilder.fromPath("/hrs/professional").buildAndExpand().toUri();
    }

    @Override
    public List<ProfessionalDetailsDTO> findAll() {
        return professionalEntityUsecases
                .findAll()
                .stream()
                .map(ProfessionalDetailsDTO::new)
                .toList();
    }

    @Override
    public ProfessionalDetailsDTO findByProfessionalId(Long professionalId) {
        ProfessionalEntity professionalEntity = professionalEntityUsecases.findByProfessionalId(professionalId);
        return professionalMapper.toProfessionalDetailsDto(professionalEntity);
    }

    @Override
    public void deleteByProfessionalId(Long professionalId) {
        professionalEntityUsecases.deleteByProfessionalId(professionalId);
    }

    @Override
    public ProfessionalDetailsDTO update(Long professionalId, ProfessionalCreationDTO newProfessionalCreation) {
        ProfessionalEntity professionalEntity = professionalEntityUsecases
                .update(professionalId, new ProfessionalEntity(newProfessionalCreation.name(), newProfessionalCreation.area()));
        return professionalMapper.toProfessionalDetailsDto(professionalEntity);
    }
}
