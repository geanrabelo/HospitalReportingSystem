package com.br.infrastructure.mapper;

import com.br.core.entity.ProfessionalEntity;
import com.br.infrastructure.domain.Professional;
import com.br.infrastructure.dto.ProfessionalCreationDTO;
import com.br.infrastructure.dto.ProfessionalDetailsDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessionalMapper {

    public Professional toProfessional(ProfessionalEntity professionalEntity){
        return Professional.builder()
                .professionalId(professionalEntity.getProfessionalId())
                .name(professionalEntity.getName())
                .area(professionalEntity.getArea())
                .build();
    }

    public ProfessionalEntity toProfessionalEntity(Professional professional){
        return new ProfessionalEntity.ProfessionalBuilder()
                .builder()
                .professionalId(professional.getProfessionalId())
                .name(professional.getName())
                .area(professional.getArea())
                .build();
    }

    public ProfessionalDetailsDTO toProfessionalDetailsDto(ProfessionalEntity professionalEntity){
        return new ProfessionalDetailsDTO(professionalEntity);
    }

    public List<Professional> toProfessionalList(List<ProfessionalEntity> professionalEntityList){
        return professionalEntityList.stream().map(this::toProfessional).toList();
    }

    public List<ProfessionalEntity> toProfessionalEntityList(List<Professional> professionalList){
        return professionalList.stream().map(this::toProfessionalEntity).toList();
    }
}
