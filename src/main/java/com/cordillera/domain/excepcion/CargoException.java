package com.cordillera.domain.excepcion;

public class CargoException extends RuntimeException{
    private static final long serialVersionUID = 1564668989254L;

    public CargoException() {
    }

    public CargoException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "CargoNofoundException [message=" + this.getMessage() + "]";
    }
}
