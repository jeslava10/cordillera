package com.cordillera.domain.excepcion;

public class CargoException extends RuntimeException{
    private static final long serialVersionUID = 1564668989254L;
    private String message;

    public CargoException() {
    }

    public CargoException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CargoNofoundException [message=" + message + "]";
    }
}
