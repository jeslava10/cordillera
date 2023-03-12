package com.cordillera.infrastructure.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControllerResponseDto<T> {
    private String error;
    private T data;

    public static <T> ControllerResponseDto<T> fromError(Exception e){
        return new ControllerResponseDto<>(e.getMessage(), null);
    }

    public static <T> ControllerResponseDto<T> fromError(String error){
        return new ControllerResponseDto<>(error, null);
    }

    public static <T> ControllerResponseDto<T> fromValid(T t){
        return new ControllerResponseDto<>(null, t);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ControllerResponseDto() {
    }

    public ControllerResponseDto(String error, T data) {
        this.error = error;
        this.data = data;
    }
}