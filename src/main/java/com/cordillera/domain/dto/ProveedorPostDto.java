package com.cordillera.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProveedorPostDto {
    @NotNull(message ="No se pueden dejar campos vacíos")
    @Schema(description = "Nombre del proveedor", example="Andres")
    private String nombre;
    @Schema(description = "Apellido del proveedor", example="Ramos")
    private String apellido;
    @Schema(description = "Numero de cedula del proveedor", example="16755")
    private BigDecimal identificacion;
    @Schema(description = "Telefono del proveedor", example="6024865888")
    private Long telefono;
    @Schema(description = "Correo electronico del proveedor", example="andres@coordillera.com")
    private String correo;

}
