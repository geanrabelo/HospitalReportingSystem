package com.br.infrastructure.domain;

import com.br.core.enums.Area;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_professional")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "professionalId")
public class Professional {

    public Professional(String name, Area area){
        this.name = name;
        this.area = area;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professionalid")
    private Long professionalId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Area area;

    @JsonIgnore
    @OneToMany(mappedBy = "professional")
    private List<Exams> examsList;
}
