package com.acolhe.app.Retrofit;

import com.acolhe.app.model.Usuario;

public class ResponseModel {
    private String message;
    private Usuario data;

    public ResponseModel(String message, Usuario data) {
        this.message = message;
        this.data = data;
    }

    public ResponseModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Usuario getData() {
        return data;
    }

    public void setData(Usuario data) {
        this.data = data;
    }
}
