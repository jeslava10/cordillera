package com.cordillera.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CargoDto {
    private Long idCargo;
    @NotNull
    private String nombreCargo;
}