package com.br.core.entity;


import com.br.core.enums.Area;

public class ProfessionalEntity {

    public ProfessionalEntity(Long professionalId, String name, Area area){
        this.professionalId = professionalId;
        this.name = name;
        this.area = area;
    }

    public ProfessionalEntity(String name, Area area){
        this.name = name;
        this.area = area;
    }

    private Long professionalId;
    private String name;
    private Area area;

    public Long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public static class ProfessionalBuilder{
        private Long professionalId;
        private String name;
        private Area area;

        public ProfessionalBuilder builder(){
            return new ProfessionalBuilder();
        }

        public ProfessionalBuilder area(Area area) {
            this.area = area;
            return this;
        }

        public ProfessionalBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProfessionalBuilder professionalId(Long professionalId) {
            this.professionalId = professionalId;
            return this;
        }

        public ProfessionalEntity build(){
            return new ProfessionalEntity(this.professionalId, this.name, this.area);
        }
    }
}
