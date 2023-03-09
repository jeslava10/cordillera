package com.cordillera.application.repository.jpa;

import com.cordillera.domain.models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    Optional<Cargo> findCargoByNombreCargo(String nombreCargo);
    Optional<Cargo> findCargoByNombreCargoContainsIgnoreCase(String nombreCargo);
    Optional<Cargo> findCargoByCodigoCargo(String codigoCargo);

}
