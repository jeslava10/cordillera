package com.cordillera.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "tbrpoveedor")
public class ProveedorDto extends ProveedorPostDto {
    @Schema(description = "id unico de la mesa", example="0")
    private Long idProveedor;

}
