package com.cordillera.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tbmesa")
public class Mesa implements Serializable {
    @Id
    @Column(name = "idmesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMesa;

    @Column(name = "numeromesa")
    private Integer numeroMesa;

    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Mesa(Long idMesa, Integer numeroMesa) {
        this.idMesa = idMesa;
        this.numeroMesa = numeroMesa;
    }

    public Mesa() {
    }
}
