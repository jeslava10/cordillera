package com.cordillera.application.resources;

public enum MensajesErrores {
    CARGO_NO_EXISTE ("No existe el cargo"),
    CARGO_YA_REGISTRADO ("El cargo ya se encuentra registrado");
    private String value;
    MensajesErrores(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
