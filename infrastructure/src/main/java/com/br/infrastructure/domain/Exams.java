package com.br.infrastructure.domain;

import com.br.core.enums.ExamsEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_exams")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "examId")
public class Exams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examid")
    private Long examId;

    @Enumerated(EnumType.STRING)
    private ExamsEnum name;

    private String description;

    private Float price;

    @Column(name = "donein")
    private LocalDateTime doneIn;

    @ManyToOne
    @JoinColumn(name = "patientid")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "professionalid")
    private Professional professional;
}
