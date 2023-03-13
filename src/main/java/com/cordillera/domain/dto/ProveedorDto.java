package com.cordillera.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Schema(description = "tbrpoveedor")
public class ProveedorDto extends ProveedorPostDto {
    @Schema(description = "id unico de la mesa", example="0")
    private Long idProveedor;

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public ProveedorDto() {
    }

    public ProveedorDto(Long idProveedor) {
        this.idProveedor = idProveedor;
    }
}
