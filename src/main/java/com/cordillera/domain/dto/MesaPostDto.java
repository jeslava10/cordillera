package com.cordillera.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MesaPostDto {

    @NotNull(message ="No se pueden dejar campos vacíos")
    @Schema(description = "numero de mesa", example="66")
    private Integer numeroMesa;

}
