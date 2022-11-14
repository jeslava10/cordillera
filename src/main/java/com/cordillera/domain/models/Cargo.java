package com.cordillera.domain.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Cargo {
    //TODO AJUSTAR LA ENTIDAD COMO ESTA TABLA DE BASE DE DATOS create table tbcargo(idcargo serial primary key,  descripcion char(40) not null);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCargo;
    private String nombreCargo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cargo cargo = (Cargo) o;
        return idCargo != null && Objects.equals(idCargo, cargo.idCargo);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
