package com.br.infrastructure.config;

import com.br.application.gateway.PatientEntityGateway;
import com.br.application.impl.PatientEntityUsecasesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientConfig {

    @Bean
    public PatientEntityUsecasesImpl patientEntityUsecasesImpl(PatientEntityGateway patientEntityGateway){
        return new PatientEntityUsecasesImpl(patientEntityGateway);
    }
}
