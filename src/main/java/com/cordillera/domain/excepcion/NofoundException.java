package com.cordillera.domain.excepcion;

public class NofoundException extends RuntimeException{

    private static final long serialVersionUID = 2409883204992760783L;
    private String message;

    public NofoundException() {}

    public NofoundException(String message) {
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
        return "NofoundException [message=" + message + "]";
    }
}
