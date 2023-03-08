package com.cordillera.application.resources;

public enum MensajesErrores {
    MENSAJE_GENERICO ("Se detectaron los siguientes errores:"),
    CARGO_NO_EXISTE ("No existe el cargo"),
    CARGO_YA_REGISTRADO ("El cargo ya se encuentra registrado"),
    CARGO_ACTUALIZAR_YA_EXISTE ("El cargo a actualizar, ya existe"),
    CARGOS_LISTA_VACIA ("No existen cargos en el sistema"),
    NOMBRE_NULL ("El nombre no puede estar vacio"),
    CARACTERES_NO_VALIDOS ("El campo no puede llevar caracteres especiales"),
    ID_CERO ("El id no puede ser cero"),
    ID_NEGATIVO ("El id no puede ser negativo"),
    CODIGO_CARGO_NULL("El codigo de cargo no puede estar vacio"),
    CODIGO_CARGO_CERO("El codigo de cargo no puede ser cero"),
    CODIGO_CARGO_NEGATIVO("El codigo de cargo no puede ser negativo");
    private String value;
    MensajesErrores(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
