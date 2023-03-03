package com.cordillera.domain.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tbcargo")
public class Cargo {

    @Id
    @Column(name = "idcargo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCargo;
    @Column(name = "descripcion")
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
