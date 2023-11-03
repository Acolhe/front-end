package com.acolhe.app.model;

public class Humor {
    private String data;
    private Integer nivelSatisfacao;
    private String comentario;

    public Humor(String data, Integer nivelSatisfacao, String comentario) {
        this.data = data;
        this.nivelSatisfacao = nivelSatisfacao;
        this.comentario = comentario;
    }

    public Humor(){

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getNivelSatisfacao() {
        return nivelSatisfacao;
    }

    public void setNivelSatisfacao(Integer nivelSatisfacao) {
        this.nivelSatisfacao = nivelSatisfacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
