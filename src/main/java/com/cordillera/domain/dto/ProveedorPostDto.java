package com.cordillera.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public BigDecimal getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(BigDecimal identificacion) {
        this.identificacion = identificacion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ProveedorPostDto() {
    }

    public ProveedorPostDto(String nombre, String apellido, BigDecimal identificacion, Long telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.correo = correo;
    }
}
