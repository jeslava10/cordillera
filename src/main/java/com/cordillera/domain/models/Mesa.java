package com.cordillera.domain.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tbmesa")
public class Mesa {
    @Id
    private Integer idmesa;

    private BigDecimal numero;

    private Integer idpedido;

}
