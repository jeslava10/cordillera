package com.cordillera.domain.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tbproveedor")
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
    private Long telefono;
    @Email
    private String correo;
}
