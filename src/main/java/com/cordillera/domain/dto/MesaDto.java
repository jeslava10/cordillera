package com.cordillera.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Schema(description = "Mesa")
public class MesaDto implements Serializable {

    @Schema(description = "id unico de la mesa", example="0")
    private Long idMesa;

    @NotNull (message ="No se pueden dejar campos vacíos")
    @Schema(description = "numero de mesa", example="66")
    private BigDecimal numeroMesa;

}
