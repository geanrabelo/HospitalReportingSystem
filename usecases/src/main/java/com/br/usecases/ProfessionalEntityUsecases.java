package com.br.usecases;

import com.br.core.entity.ProfessionalEntity;

import java.util.List;

public interface ProfessionalEntityUsecases {

    void create(ProfessionalEntity professionalEntity);

    ProfessionalEntity findByProfessionalId(Long professionalId);

    boolean existsByProfessionalId(Long professionalId);

    List<ProfessionalEntity> findAll();

    void deleteByProfessionalId(Long professionalId);

    ProfessionalEntity update(Long professionalId, ProfessionalEntity newProfessionalEntity);

}
