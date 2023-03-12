package com.cordillera.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public class MesaPostDto {
    @NotNull(message ="No se pueden dejar campos vacíos")
    @Schema(description = "numero de mesa", example="66")
    private Integer numeroMesa;

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public MesaPostDto() {
    }

    public MesaPostDto(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
}
