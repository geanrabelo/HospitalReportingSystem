package com.br.infrastructure.dto;

import com.br.core.entity.ProfessionalEntity;
import com.br.core.enums.Area;

public record ProfessionalDetailsDTO(Long professionalId,
                                     String name,
                                     Area area) {
    public ProfessionalDetailsDTO(ProfessionalEntity professionalEntity){
        this(professionalEntity.getProfessionalId(), professionalEntity.getName(), professionalEntity.getArea());
    }
}
