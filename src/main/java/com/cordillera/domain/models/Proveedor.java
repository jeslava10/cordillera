package com.cordillera.domain.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class Proveedor {
    @Id
    @Column(name = "idproveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private BigDecimal identificacion;
    @NotNull
    private Integer telefono;
    @Email
    private String correo;

}
