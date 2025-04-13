package com.br.application.impl;

import com.br.application.gateway.ProfessionalEntityGateway;
import com.br.core.entity.ProfessionalEntity;

import java.util.List;

public class ProfessionalEntityUsecasesImpl implements com.br.usecases.ProfessionalEntityUsecases {

    private ProfessionalEntityGateway professionalEntityGateway;

    public ProfessionalEntityUsecasesImpl(ProfessionalEntityGateway professionalEntityGateway){
        this.professionalEntityGateway = professionalEntityGateway;
    }

    public ProfessionalEntityUsecasesImpl(){}

    @Override
    public void create(ProfessionalEntity professionalEntity) {
        professionalEntityGateway.create(professionalEntity);
    }

    @Override
    public ProfessionalEntity findByProfessionalId(Long professionalId) {
        return professionalEntityGateway.findByProfessionalId(professionalId);
    }

    @Override
    public boolean existsByProfessionalId(Long professionalId) {
        return false;
    }

    @Override
    public List<ProfessionalEntity> findAll() {
        return professionalEntityGateway.findAll();
    }

    @Override
    public void deleteByProfessionalId(Long professionalId) {
        professionalEntityGateway.deleteByProfessionalId(professionalId);
    }

    @Override
    public ProfessionalEntity update(Long professionalId, ProfessionalEntity newProfessionalEntity) {
        return professionalEntityGateway.update(professionalId, newProfessionalEntity);
    }
}
