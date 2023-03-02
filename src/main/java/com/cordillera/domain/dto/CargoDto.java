package com.cordillera.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CargoDto {

    //TODO AJUSTAR CON CAMBIOS REALIZADOS EN ENTIDAD
    //TODO  ASIGANAR MENSAJE EN EL @NOTNULL
    @NotNull
    private Long idCargo;
    @NotNull
    private String nombreCargo;
}
