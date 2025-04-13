package com.br.infrastructure.repositories;

import com.br.infrastructure.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    boolean existsByPatientId(Long patientId);
}
