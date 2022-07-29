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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HttpClientException [code=" + code + ", message=" + message + "]";
    }

}
