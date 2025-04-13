package com.br.core.entity;

import java.time.LocalDateTime;
import java.util.List;

public class PatientEntity {

    public PatientEntity(Long patientId, String name, Integer age, String numberPhone){
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.numberPhone = numberPhone;
        this.registeredAt = LocalDateTime.now();
    }

    private Long patientId;
    private String name;
    private Integer age;
    private String numberPhone;
    private LocalDateTime registeredAt;
    private List<ExamsEntity> examsEntityList;

    private void addExam(ExamsEntity examsEntity){
        examsEntityList.add(examsEntity);
    }

    public List<ExamsEntity> getExamsList() {
        return examsEntityList;
    }

    public void setExamsList(List<ExamsEntity> examsEntityList) {
        this.examsEntityList = examsEntityList;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public static class PatientEntityBuilder {
        private Long patientId;
        private String name;
        private Integer age;
        private String numberPhone;
        private LocalDateTime registeredAt;
        private List<ExamsEntity> examsEntityList;

        public PatientEntityBuilder builder(){
            return new PatientEntityBuilder();
        }

        public PatientEntityBuilder patientId(Long patientId){
            this.patientId = patientId;
            return this;
        }

        public PatientEntityBuilder name(String name){
            this.name = name;
            return this;
        }

        public PatientEntityBuilder age(Integer age){
            this.age = age;
            return this;
        }

        public PatientEntityBuilder numberPhone(String numberPhone){
            this.numberPhone = numberPhone;
            return this;
        }

        public PatientEntityBuilder registeredAt(LocalDateTime localDateTime){
            this.registeredAt = localDateTime;
            return this;
        }

        public PatientEntity build(){
            return new PatientEntity(this.patientId, this.name, this.age, this.numberPhone);
        }
    }
}
