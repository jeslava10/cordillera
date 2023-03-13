package com.cordillera.domain.excepcion;

public class HttpClientException extends RuntimeException{

    private static final long serialVersionUID = -127338401312440198L;
    private int code;
    private String message;

    public HttpClientException() {}

    public HttpClientException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
