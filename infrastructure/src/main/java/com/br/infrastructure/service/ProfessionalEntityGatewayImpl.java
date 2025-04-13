package com.br.infrastructure.service;

import com.br.application.gateway.ProfessionalEntityGateway;
import com.br.core.entity.ProfessionalEntity;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.ProfessionalIdNotFound;
import com.br.core.exceptions.ProfessionalNameAlreadyExists;
import com.br.infrastructure.domain.Professional;
import com.br.infrastructure.mapper.ProfessionalMapper;
import com.br.infrastructure.repositories.ProfessionalRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfessionalEntityGatewayImpl implements ProfessionalEntityGateway {

    private final ProfessionalRepository professionalRepository;
    private final ProfessionalMapper professionalMapper;

    public ProfessionalEntityGatewayImpl(ProfessionalRepository professionalRepository, ProfessionalMapper professionalMapper){
        this.professionalRepository = professionalRepository;
        this.professionalMapper = professionalMapper;
    }

    @Override
    public void create(ProfessionalEntity professionalEntity) {
        if(!professionalRepository.existsByName(professionalEntity.getName())){
            Professional professional = professionalMapper.toProfessional(professionalEntity);
            professionalRepository.save(professional);
        }else{
            throw new ProfessionalNameAlreadyExists(EnumCode.PRO0001.getMessage());
        }
    }

    @Override
    public ProfessionalEntity findByProfessionalId(Long professionalId) {
        if(existsByProfessionalId(professionalId)){
            Professional professionalDB = professionalRepository.getReferenceById(professionalId);
            return professionalMapper.toProfessionalEntity(professionalDB);
        }
        throw new ProfessionalIdNotFound(EnumCode.PRO0000.getMessage());
    }

    @Override
    public boolean existsByProfessionalId(Long professionalId) {
        return professionalRepository.existsByProfessionalId(professionalId);
    }

    @Override
    public List<ProfessionalEntity> findAll() {
        List<Professional> professionalList = professionalRepository.findAll();
        return professionalMapper.toProfessionalEntityList(professionalList);
    }

    @Override
    public void deleteByProfessionalId(Long professionalId) {
        if(existsByProfessionalId(professionalId)){
            professionalRepository.deleteById(professionalId);
        }else{
            throw new ProfessionalIdNotFound(EnumCode.PRO0000.getMessage());
        }
    }

    @Override
    public ProfessionalEntity update(Long professionalId, ProfessionalEntity newProfessionalEntity) {
        if(existsByProfessionalId(professionalId)){
            Professional professionalDB = professionalRepository.getReferenceById(professionalId);
            if(newProfessionalEntity.getArea() != null){
                professionalDB.setArea(newProfessionalEntity.getArea());
            }
            return professionalMapper.toProfessionalEntity(professionalRepository.save(professionalDB));
        }
        throw new ProfessionalIdNotFound(EnumCode.PRO0000.getMessage());
    }
}
