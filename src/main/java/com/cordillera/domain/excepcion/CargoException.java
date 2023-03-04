package com.cordillera.domain.excepcion;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CargoException extends RuntimeException{

    public CargoException(String message) {
        super(message);
    }
}
