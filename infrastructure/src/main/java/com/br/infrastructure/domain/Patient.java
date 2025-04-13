package com.br.infrastructure.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_patient")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(of = "patientId")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientid")
    private Long patientId;

    private String name;

    private Integer age;

    @Column(name = "numberphone")
    private String numberPhone;

    @Column(name = "registeredat")
    private LocalDateTime registeredAt;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<Exams> examsList;
}
