package com.br.infrastructure.repositories;

import com.br.infrastructure.domain.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {

    boolean existsByName(String name);
    boolean existsByProfessionalId(Long id);
}
