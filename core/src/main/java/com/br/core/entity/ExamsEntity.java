package com.br.core.entity;

import com.br.core.enums.ExamsEnum;

import java.time.LocalDateTime;

public class ExamsEntity {

    public ExamsEntity(Long examId, ExamsEnum name, String description, PatientEntity patientEntity,ProfessionalEntity professionalEntity) {
        this.examId = examId;
        this.name = name;
        this.description = description;
        this.price = name.getValor();
        this.doneIn = LocalDateTime.now();
        this.patientEntity = patientEntity;
        this.professionalEntity = professionalEntity;
    }

    public ExamsEntity(String description){
        this.description = description;
    }

    private Long examId;
    private ExamsEnum name;
    private String description;
    private Float price;
    private LocalDateTime doneIn;
    private PatientEntity patientEntity;
    private ProfessionalEntity professionalEntity;

    public Long getExamId() {
        return examId;
    }

    public PatientEntity getPatientEntity() {
        return patientEntity;
    }

    public void setPatientEntity(PatientEntity patientEntity) {
        this.patientEntity = patientEntity;
    }

    public ProfessionalEntity getProfessionalEntity() {
        return professionalEntity;
    }

    public void setProfessionalEntity(ProfessionalEntity professionalEntity) {
        this.professionalEntity = professionalEntity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public LocalDateTime getDoneIn() {
        return doneIn;
    }

    public void setDoneIn(LocalDateTime doneIn) {
        this.doneIn = doneIn;
    }

    public ProfessionalEntity getProfessional() {
        return professionalEntity;
    }

    public void setProfessional(ProfessionalEntity professionalEntity) {
        this.professionalEntity = professionalEntity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ExamsEnum getName() {
        return name;
    }

    public void setName(ExamsEnum name) {
        this.name = name;
    }

    public static class ExamsEntityBuilder {
        private Long examId;
        private ExamsEnum name;
        private String description;
        private Float price;
        private LocalDateTime doneIn;
        private PatientEntity patientEntity;
        private ProfessionalEntity professionalEntity;

        public ExamsEntityBuilder builder(){
            return new ExamsEntityBuilder();
        }

        public ExamsEntityBuilder professional(ProfessionalEntity professionalEntity) {
            this.professionalEntity = professionalEntity;
            return this;
        }

        public ExamsEntityBuilder patient(PatientEntity patientEntity){
            this.patientEntity = patientEntity;
            return this;
        }

        public ExamsEntityBuilder price(Float price) {
            this.price = price;
            return this;
        }

        public ExamsEntityBuilder doneIn(LocalDateTime doneIn) {
            this.doneIn = doneIn;
            return this;
        }

        public ExamsEntityBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ExamsEntityBuilder name(ExamsEnum name) {
            this.name = name;
            return this;
        }

        public ExamsEntityBuilder examId(Long examId) {
            this.examId = examId;
            return this;
        }

        public ExamsEntity build(){
            return new ExamsEntity(this.examId, this.name, this.description, this.patientEntity, this.professionalEntity);
        }
    }
}
