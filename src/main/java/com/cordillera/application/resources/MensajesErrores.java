package com.cordillera.application.resources;

public enum MensajesErrores {
    CARGO_NO_EXISTE ("No existe el cargo"),
    CARGO_YA_REGISTRADO ("El cargo ya se encuentra registrado"),
    CARGO_ACTUALIZAR_YA_EXISTE ("El cargo a actualizar, ya existe"),
    CARGOS_LISTA_VACIA ("No existen cargos en el sistema"),
    ID_CERO ("El id no puede ser cero"),
    ID_NEGATIVO ("El id no puede ser negativo"),
    NOMBRE_NULL ("El nombre no puede estar vacio");
    private String value;
    MensajesErrores(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
