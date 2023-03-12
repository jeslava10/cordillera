package com.cordillera.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tbcargo")
@NoArgsConstructor
public @Data class Cargo implements Serializable {

    @Id
    @Column(name = "idcargo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCargo;

    @Column(name = "descripcion")
    private String nombreCargo;

    @Column(name = "codigocargo")
    private String codigoCargo;

}
