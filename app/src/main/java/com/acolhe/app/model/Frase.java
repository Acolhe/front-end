package com.acolhe.app.model;

public class Frase {
    private String frase;
    private String dataCriacao;

    public Frase(String frase, String dataCriacao) {
        this.frase = frase;
        this.dataCriacao = dataCriacao;
    }

    public Frase() {
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}

