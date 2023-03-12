package com.cordillera.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Schema(description = "Mesa")
public class MesaDto extends MesaPostDto {
    @Schema(description = "id unico de la mesa", example="0")
    private Long idMesa;

    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public MesaDto() {
    }

    public MesaDto(Long idMesa) {
        this.idMesa = idMesa;
    }
}
