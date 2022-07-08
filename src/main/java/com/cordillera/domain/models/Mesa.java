package com.cordillera.domain.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tbmesa")
public class Mesa {
    @Id
    @Column(name = "idmesa")
    private Long idMesa;

    @Column(name = "numeromesa")
    private BigDecimal numeroMesa;

}
