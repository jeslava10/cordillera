package com.cordillera.domain.excepcion;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UsuarioException extends RuntimeException{

    public UsuarioException(String message) {
        super(message);
    }
}
