package com.cordillera.domain.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tbmesa")
public class Mesa implements Serializable {
    @Id
    @Column(name = "idmesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMesa;

    @Column(name = "numeromesa")
    private BigDecimal numeroMesa;

}
