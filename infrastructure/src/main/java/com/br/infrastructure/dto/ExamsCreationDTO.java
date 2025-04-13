package com.br.infrastructure.dto;

import com.br.core.enums.ExamsEnum;

public record ExamsCreationDTO(ExamsEnum name,
                              String description,
                              Long patientId,
                              Long professionalId) {
}
