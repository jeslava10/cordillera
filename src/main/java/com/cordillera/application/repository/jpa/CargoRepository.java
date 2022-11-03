package com.cordillera.application.repository.jpa;

import com.cordillera.domain.models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}