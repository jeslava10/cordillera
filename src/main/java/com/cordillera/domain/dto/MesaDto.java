package com.cordillera.domain.dto;



import lombok.Data;


import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class MesaDto {

    private Long idMesa;

    @NotNull (message ="No se pueden dejar campos vacíos")
    private BigDecimal numeroMesa;

}
