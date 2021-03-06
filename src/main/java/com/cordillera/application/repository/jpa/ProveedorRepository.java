package com.cordillera.application.repository.jpa;


import com.cordillera.domain.models.Mesa;
import com.cordillera.domain.models.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    Optional<Proveedor> findByIdentificacion(BigDecimal identificacion);
}
