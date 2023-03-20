package com.cordillera.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CargoPostDto {
    @NotNull
    private String nombreCargo;
    @NotNull
    private String codigoCargo;
}
