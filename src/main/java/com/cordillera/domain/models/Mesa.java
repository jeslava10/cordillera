package com.cordillera.domain.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tbmesa")
public @Data class Mesa implements Serializable {
    @Id
    @Column(name = "idmesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMesa;

    @Column(name = "numeromesa")
    private BigDecimal numeroMesa;


}
