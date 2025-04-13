package com.br.infrastructure.config;

import com.br.application.gateway.ExamsEntityGateway;
import com.br.application.impl.ExamsEntityUsecasesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExamsConfig {

    @Bean
    public ExamsEntityUsecasesImpl examsEntityUsecasesImpl(ExamsEntityGateway examsEntityGateway){
        return new ExamsEntityUsecasesImpl(examsEntityGateway);
    }
}
