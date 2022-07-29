package com.cordillera.domain.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class Proveedor {
    @Id
    @Column(name = "idproveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;
    private String nombre;
    private String apellido;
    private BigDecimal identificacion;
    private Integer telefono;
    private String correo;

}
