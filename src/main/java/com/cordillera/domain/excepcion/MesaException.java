package com.cordillera.domain.excepcion;

public class MesaException extends RuntimeException{

    private static final long serialVersionUID = 2409883204992760783L;
    private String message;

    public MesaException() {}

    public MesaException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MesaNofoundException [message=" + message + "]";
    }
}
