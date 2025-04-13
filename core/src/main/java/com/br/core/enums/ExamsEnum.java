package com.br.core.enums;

public enum ExamsEnum {
    RAIOXCRANIO("Raiox Crânio", 70.0F),
    RAIOXSEIOSDAFACE("Raiox Seios Da Face", 70.0F),
    RAIOXTORAX("Raiox Tórax", 70.0F),
    RAIOXCOLUNACERVICAL("Coluna Cervical", 70.0F),
    RAIOXCOLUNADORSAL("Coluna Dorsal", 70.0F),
    RAIOXCOLUNALOMBAR("Coluna Lombar", 70.0F),
    RAIOXBACIA("Bacia", 70.0F),
    RAIOXJOELHO("Joelho", 70.0F),
    RAIOXTORNOZELO("Tornozelo", 70.0F),
    RAIOXPE("Pé", 70.0F),
    RAIOXCALCANEO("Calcâneo", 70.0F),
    MAMOGRAFIA("Mamografia", 80.0F),
    DENSITOMETRIA("Densitometria Óssea", 80.0F),
    USGABDOMENTOTAL("Ultrassonografia Abdomen Total",120.0F),
    USGAPARARELHOURINARIO("Ultrassonografia Aparalho Urinário",120.0F),
    USGTRANSVAGINAL("Ultrassonografia Transvaginal",120.0F),
    USGPROSTATA("Ultrassonografia Próstata",120.0F),
    USGPELVICA("Ultrassonografia Pélvica",120.0F),
    USGMUSCULOESQUELETICO("Ultrassonografia Musculo Esquelético",120.0F),
    USGOMBRO("Ultrassonografia Ombro", 120.0F),
    USGCOTOVELO("Ultrassonografia Cotovelo", 120.0F),
    USGJOELHO("Ultrassonografia Joelho", 120.0F),
    USGPE("Ultrassonografia Pé", 120.0F);

    private String name;
    private Float valor;

    ExamsEnum(String name, Float valor){
        this.name = name;
        this.valor = valor;
    }

    public String getName(){
        return this.name;
    }
    public Float getValor(){
        return this.valor;
    }
}
