package com.cordillera.domain.excepcion;

public class ProveedorException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;
    public ProveedorException(String message) {
        super(message);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
