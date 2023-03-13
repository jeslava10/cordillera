
package com.cordillera.application.resources;

public enum MensajesErrores {
    MESA_NO_EXISTE_DELETE ("La mesa no existe y no se puede borrar"),
    MESA_NO_EXISTE_UPDATE ("La mesa no exite, no se puede actrualizar"),
    MESA_NO_EXISTEN_CONSULTAR ("No existen mesas para consultar"),
    MESA_NO_EXISTE_CONSULTAR ("No existe codigo de mesa para consultar"),
    MESA_NUMERO_EXISTE ("Numero de mesa ya catalogado"),
    MESA_NUMERO_NO_VALIDO ("Numero de la mesa no es valido"),
    PRPVEEDOR_IDENTIFICACION_DUPLICADO ("Numero de identificaicon esta catalogado en otro proveedor"),
    PROVEEDOR_NO_EXISTE_DELETE ("El proveedor no existe y no se puede borrar"),
    PROVEEDORES_NO_EXISTEN ("No existen proveedores para consultar"),
    PROVEEDOR_NO_EXISTE_CONSULTAR ("No existe id del proveedor para consultar"),
    PROVEEDOR_NO_EXISTE_UPDATE ("El proveedor no exite, no se puede actrualizar");
    private String value;
    MensajesErrores(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}