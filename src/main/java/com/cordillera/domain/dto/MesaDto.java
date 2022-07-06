package com.cordillera.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MesaDto {

    private Integer idmesa;

    private BigDecimal numero;

    private Integer idpedido;
}
