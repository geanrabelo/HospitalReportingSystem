package com.br.infrastructure.dto;

import com.br.core.entity.ProfessionalEntity;
import com.br.core.enums.Area;

public record ProfessionalCreationDTO(String name, Area area) {
    public ProfessionalCreationDTO(ProfessionalEntity professionalEntity){
        this(professionalEntity.getName(), professionalEntity.getArea());
    }
}
