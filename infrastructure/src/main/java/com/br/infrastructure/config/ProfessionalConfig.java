package com.br.infrastructure.config;

import com.br.application.gateway.ProfessionalEntityGateway;
import com.br.application.impl.ProfessionalEntityUsecasesImpl;
import com.br.usecases.ProfessionalEntityUsecases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfessionalConfig {

    @Bean
    public ProfessionalEntityUsecasesImpl professionalEntityUsecasesImpl(ProfessionalEntityGateway professionalEntityGateway){
        return new ProfessionalEntityUsecasesImpl(professionalEntityGateway);
    }
}
