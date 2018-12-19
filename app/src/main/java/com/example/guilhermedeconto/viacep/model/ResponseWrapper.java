package com.example.guilhermedeconto.viacep.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 14/12/2018
 */
public class ResponseWrapper<T> {

    @SerializedName("Success")
    private boolean success;
    @SerializedName("Message")
    private String message;
    @SerializedName("Result")
    private T data;


    public ResponseWrapper() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
