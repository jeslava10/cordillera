package com.cordillera.domain.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCargo;
    private String nombreCargo;
}
