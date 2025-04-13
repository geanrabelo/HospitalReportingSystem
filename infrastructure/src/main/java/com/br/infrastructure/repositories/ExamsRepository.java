package com.br.infrastructure.repositories;

import com.br.infrastructure.domain.Exams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExamsRepository extends JpaRepository<Exams, Long> {

    boolean existsByExamId(Long examId);

    @Query("SELECT E FROM Exams E WHERE E.patient.patientId = :patientId")
    List<Exams> findByPatientId(Long patientId);
}
